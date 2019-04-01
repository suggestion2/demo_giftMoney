package com.demo.giftmoney.controller.management;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.interceptor.LoginRequired;
import com.demo.giftmoney.request.ArticleStatusForm;
import com.demo.giftmoney.service.GiftMoneyService;
import com.demo.giftmoney.serviceImpl.OssService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import com.demo.giftmoney.domain.Article;
import com.demo.giftmoney.service.ArticleService;
import com.demo.giftmoney.request.ArticleCreateForm;
import com.demo.giftmoney.request.ArticleUpdateForm;
import com.demo.giftmoney.request.ArticleListForm;
import com.demo.giftmoney.response.ArticleListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.demo.giftmoney.constants.ArticleConstants.DISABLED;
import static com.demo.giftmoney.constants.ArticleConstants.ENABLED;
import static com.demo.giftmoney.constants.CommonConstants.*;
import static com.demo.giftmoney.serviceImpl.ImageConstants.ARTICLE;

@RestController
@RequestMapping(value = "/management/article")
@LoginRequired
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private GiftMoneyService giftMoneyService;

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private OssService ossService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public ArticleListView list(@Valid @RequestBody ArticleListForm form){
        return new ArticleListView(articleService.selectViewList(form.getQueryMap()),articleService.selectCount(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public Article detail(@PathVariable Integer id){
        Article article = articleService.getById(id);
        if(Objects.isNull(article)){
            throw new ResourceNotFoundException("article not found");
        }
        article.setImg(ossService.getBucket(ARTICLE) + article.getImg());
        return article;
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public ResponseView create(@Valid @RequestBody ArticleCreateForm form){
        Article article = articleService.getByTitle(form.getTitle());
        if(Objects.nonNull(article)){
            throw new InvalidRequestException("duplicateTitle","duplicate article title");
        }
        GiftMoney giftMoney = giftMoneyService.getById(form.getGiftMoneyId());
        if(Objects.isNull(giftMoney)){
            throw new ResourceNotFoundException("giftMoney not found");
        }
        article = new Article();
        BeanUtils.copyProperties(form,article);
        article.setCreateBy(sessionContext.getUser().getId());
        articleService.create(article);
        return new ResponseView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public ResponseView update(@Valid @RequestBody ArticleUpdateForm form){
        Article article = articleService.getById(form.getId());
        if(Objects.isNull(article)){
            throw new ResourceNotFoundException("article not exists");
        }
        GiftMoney giftMoney = giftMoneyService.getById(form.getGiftMoneyId());
        if(Objects.isNull(giftMoney)){
            throw new ResourceNotFoundException("giftMoney not found");
        }
        if(article.getStatus().equals(ENABLED)){
            throw new InvalidRequestException("invalidStatus","invalid article status");
        }
        Article duplicateTitleArticle = articleService.getByTitle(form.getTitle());
        if(Objects.nonNull(duplicateTitleArticle) && !duplicateTitleArticle.getId().equals(form.getId())){
            throw new InvalidRequestException("duplicateTitle","duplicate article title");
        }
        BeanUtils.copyProperties(form,article);
        article.setUpdateBy(sessionContext.getUser().getId());
        articleService.update(article);
        return new ResponseView();
    }

    @RequestMapping(value = "/status",method = RequestMethod.PUT)
    public ResponseView status(@Valid @RequestBody ArticleStatusForm form){
        Article article = articleService.getById(form.getId());
        if(Objects.isNull(article)){
            throw new ResourceNotFoundException("article not exists");
        }
        if(!article.getStatus().equals(ENABLED) && !article.getStatus().equals(DISABLED)){
            throw new InvalidRequestException("invalidStatus","invalid article status");
        }
        BeanUtils.copyProperties(form,article);
        article.setUpdateBy(sessionContext.getUser().getId());
        articleService.updateStatus(article);
        return new ResponseView();
    }
}
