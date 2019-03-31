package com.demo.giftmoney.controller.api;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.domain.Article;
import com.demo.giftmoney.domain.ArticleRecord;
import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.interceptor.LoginRequired;
import com.demo.giftmoney.interceptor.WechatLoginRequired;
import com.demo.giftmoney.request.*;
import com.demo.giftmoney.response.ArticleListView;
import com.demo.giftmoney.response.ArticleShareView;
import com.demo.giftmoney.service.ArticleRecordService;
import com.demo.giftmoney.service.ArticleService;
import com.demo.giftmoney.service.GiftMoneyService;
import com.demo.giftmoney.serviceImpl.OssService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.platform.wechat.constants.WeChatJsInter;
import com.sug.core.platform.wechat.request.WeChatJsConfigForm;
import com.sug.core.platform.wechat.response.WeChatJsConfigResponse;
import com.sug.core.platform.wechat.service.WeChatJsParamsService;
import com.sug.core.rest.view.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.demo.giftmoney.constants.ArticleConstants.ENABLED;
import static com.demo.giftmoney.constants.ArticleConstants.READ_DURATION;
import static com.demo.giftmoney.constants.ArticleConstants.SHARE_DURATION;
import static com.demo.giftmoney.constants.CommonConstants.*;
import static com.demo.giftmoney.serviceImpl.ImageConstants.ARTICLE;

@RestController("articleApiController")
@RequestMapping(value = "/api/article")
//@WechatLoginRequired
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRecordService articleRecordService;

    @Autowired
    private WeChatJsParamsService weChatJsParamsService;

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private OssService ossService;

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Article detail(@RequestParam("articleId") Integer articleId,@RequestParam(name = "customerId",required = false) Integer sourceCustomerId) throws Exception {
        if(Objects.nonNull(sourceCustomerId) && sourceCustomerId.equals(sessionContext.getCustomerId())){
            throw new InvalidRequestException("invalid customer");
        }
        if(Objects.nonNull(sessionContext.getBeginReadTime()) && System.currentTimeMillis() - READ_DURATION < sessionContext.getBeginReadTime()){
            throw new InvalidRequestException("read time is too short");
        }
        Article article = articleService.getById(articleId);
        if(Objects.isNull(article)){
            throw new ResourceNotFoundException("article not found");
        }
        articleRecordService.read(sessionContext.getCustomerId(),sessionContext.getOpenId(),sessionContext.getCustomerName(),articleId,article.getTitle(),article.getGiftMoneyId(),sourceCustomerId);
        sessionContext.setGiftMoneyId(article.getGiftMoneyId());
        sessionContext.setArticleId(articleId);
        sessionContext.setArticleTitle(article.getTitle());
        sessionContext.setBeginReadTime();
        article.setImg(ossService.getBucket(ARTICLE) + article.getImg());
        return article;
    }

    @RequestMapping(value = "/share",method = RequestMethod.GET)
    public ResponseView share(@RequestParam("path") Integer path){
        if(!Objects.equals(path,1) && !Objects.equals(path,2)){
            throw new InvalidRequestException("invalid path");
        }
        if(Objects.isNull(sessionContext.getArticleId())){
            throw new InvalidRequestException("read article first");
        }
        if(System.currentTimeMillis() - READ_DURATION < sessionContext.getBeginReadTime()){
            throw new InvalidRequestException("read time is too short");
        }
        if(System.currentTimeMillis() - SHARE_DURATION < sessionContext.getLastShareTime()){
            throw new InvalidRequestException("share time is too short");
        }
        ArticleRecord articleRecord = articleRecordService.getByCustomerArticle(sessionContext.getCustomerId(),sessionContext.getArticleId());
        articleRecordService.share(articleRecord.getId(),path);
        sessionContext.setLastShareTime();
        return new ResponseView();
    }

    @RequestMapping(value = "/shareParams",method = RequestMethod.POST)
    public WeChatJsConfigResponse getWechatShareJsParams(@Valid @RequestBody WeChatJsConfigForm form) throws Exception {
        List<String> interfaceList = new ArrayList<>();
        interfaceList.add(WeChatJsInter.TIMELINE_SHARE_2);
        interfaceList.add(WeChatJsInter.APPMESSAGE_SHARE_2);
        return weChatJsParamsService.getJsConfigParams(form.getUrl(),interfaceList);
    }
}
