package com.demo.giftmoney.controller.api;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.domain.Article;
import com.demo.giftmoney.domain.ArticleRecord;
import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.interceptor.LoginRequired;
import com.demo.giftmoney.interceptor.WechatLoginRequired;
import com.demo.giftmoney.request.ArticleCreateForm;
import com.demo.giftmoney.request.ArticleListForm;
import com.demo.giftmoney.request.ArticleStatusForm;
import com.demo.giftmoney.request.ArticleUpdateForm;
import com.demo.giftmoney.response.ArticleListView;
import com.demo.giftmoney.response.ArticleShareView;
import com.demo.giftmoney.service.ArticleRecordService;
import com.demo.giftmoney.service.ArticleService;
import com.demo.giftmoney.service.GiftMoneyService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

import static com.demo.giftmoney.constants.ArticleConstants.ENABLED;
import static com.demo.giftmoney.constants.ArticleConstants.READ_DURATION;
import static com.demo.giftmoney.constants.ArticleConstants.SHARE_DURATION;
import static com.demo.giftmoney.constants.CommonConstants.*;

@RestController("articleApiController")
@RequestMapping(value = "/api/article")
@WechatLoginRequired
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRecordService articleRecordService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Article detail(@RequestParam("articleId") Integer articleId,@RequestParam(name = "customerId",required = false) Integer sourceCustomerId) throws Exception {
        if(System.currentTimeMillis() - READ_DURATION < sessionContext.getBeginReadTime()){
            throw new InvalidRequestException("read time is too short");
        }
        Article article = articleService.getById(articleId);
        if(Objects.isNull(article)){
            throw new ResourceNotFoundException("article not found");
        }
        articleRecordService.read(sessionContext.getCustomerId(),sessionContext.getOpenId(),sessionContext.getCustomerName(),articleId,article.getTitle(),article.getGiftMoneyId(),sourceCustomerId);
        sessionContext.setGiftMoneyId(article.getGiftMoneyId());
        sessionContext.setArticleId(articleId);
        sessionContext.setBeginReadTime();
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
}
