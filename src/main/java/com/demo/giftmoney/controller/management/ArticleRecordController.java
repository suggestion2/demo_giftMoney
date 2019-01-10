package com.demo.giftmoney.controller.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.rest.view.SuccessView;
import com.demo.giftmoney.domain.ArticleRecord;
import com.demo.giftmoney.service.ArticleRecordService;
import com.demo.giftmoney.request.ArticleRecordCreateForm;
import com.demo.giftmoney.request.ArticleRecordUpdateForm;
import com.demo.giftmoney.request.ArticleRecordListForm;
import com.demo.giftmoney.response.ArticleRecordListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.demo.giftmoney.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/management/articleRecord")
public class ArticleRecordController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleRecordController.class);

    @Autowired
    private ArticleRecordService articleRecordService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public ArticleRecordListView list(@Valid @RequestBody ArticleRecordListForm form){
        return new ArticleRecordListView(articleRecordService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public ArticleRecord detail(@PathVariable Integer id){
        return articleRecordService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody ArticleRecordCreateForm form){
        ArticleRecord articleRecord = new ArticleRecord();
        BeanUtils.copyProperties(form,articleRecord);
        articleRecordService.create(articleRecord);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody ArticleRecordUpdateForm form){
        ArticleRecord articleRecord = articleRecordService.getById(form.getId());
        if(Objects.isNull(articleRecord)){
            throw new ResourceNotFoundException("articleRecord not exists");
        }
        BeanUtils.copyProperties(form,articleRecord);
        articleRecordService.update(articleRecord);
        return new SuccessView();
    }
}
