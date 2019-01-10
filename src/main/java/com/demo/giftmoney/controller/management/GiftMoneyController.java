package com.demo.giftmoney.controller.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.rest.view.SuccessView;
import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.service.GiftMoneyService;
import com.demo.giftmoney.request.GiftMoneyCreateForm;
import com.demo.giftmoney.request.GiftMoneyUpdateForm;
import com.demo.giftmoney.request.GiftMoneyListForm;
import com.demo.giftmoney.response.GiftMoneyListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.demo.giftmoney.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/management/giftMoney")
public class GiftMoneyController {

    private static final Logger logger = LoggerFactory.getLogger(GiftMoneyController.class);

    @Autowired
    private GiftMoneyService giftMoneyService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public GiftMoneyListView list(@Valid @RequestBody GiftMoneyListForm form){
        return new GiftMoneyListView(giftMoneyService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public GiftMoney detail(@PathVariable Integer id){
        return giftMoneyService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody GiftMoneyCreateForm form){
        GiftMoney giftMoney = new GiftMoney();
        BeanUtils.copyProperties(form,giftMoney);
        giftMoneyService.create(giftMoney);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody GiftMoneyUpdateForm form){
        GiftMoney giftMoney = giftMoneyService.getById(form.getId());
        if(Objects.isNull(giftMoney)){
            throw new ResourceNotFoundException("giftMoney not exists");
        }
        BeanUtils.copyProperties(form,giftMoney);
        giftMoneyService.update(giftMoney);
        return new SuccessView();
    }
}
