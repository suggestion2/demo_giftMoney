package com.demo.giftmoney.controller.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
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

import static com.demo.giftmoney.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/management/article")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public ArticleListView list(@Valid @RequestBody ArticleListForm form){
        return new ArticleListView(articleService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public Article detail(@PathVariable Integer id){
        return articleService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody ArticleCreateForm form){
        Article article = new Article();
        BeanUtils.copyProperties(form,article);
        articleService.create(article);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody ArticleUpdateForm form){
        Article article = articleService.getById(form.getId());
        if(Objects.isNull(article)){
            throw new ResourceNotFoundException("article not exists");
        }
        BeanUtils.copyProperties(form,article);
        articleService.update(article);
        return new SuccessView();
    }
}
