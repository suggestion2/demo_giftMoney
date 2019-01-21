package com.demo.giftmoney.controller.management;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.interceptor.LoginRequired;
import com.demo.giftmoney.request.GiftMoneyStatusForm;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.service.GiftMoneyService;
import com.demo.giftmoney.request.GiftMoneyCreateForm;
import com.demo.giftmoney.request.GiftMoneyUpdateForm;
import com.demo.giftmoney.request.GiftMoneyListForm;
import com.demo.giftmoney.response.GiftMoneyListView;
import com.sug.core.util.SequenceNumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.math.BigDecimal;
import java.util.Objects;

import static com.demo.giftmoney.constants.CommonConstants.*;
import static com.demo.giftmoney.constants.GiftMoneyConstants.*;

@RestController
@RequestMapping(value = "/management/giftMoney")
@LoginRequired
public class GiftMoneyController {

    private static final Logger logger = LoggerFactory.getLogger(GiftMoneyController.class);

    @Autowired
    private GiftMoneyService giftMoneyService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public GiftMoneyListView list(@Valid @RequestBody GiftMoneyListForm form){
        return new GiftMoneyListView(giftMoneyService.selectList(form.getQueryMap()),giftMoneyService.selectCount(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public GiftMoney detail(@PathVariable Integer id){
        return giftMoneyService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public ResponseView create(@Valid @RequestBody GiftMoneyCreateForm form){
        if(form.getTotalAmount().compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidRequestException("invalidAmount","invalid amount");
        }
        if(form.getLow().compareTo(form.getUpper()) > 0){
            throw new InvalidRequestException("invalidLimit","invalid amount limit");
        }
        if(form.getStartDate().compareTo(form.getEndDate()) > 0){
            throw new InvalidRequestException("invalidDate","invalid date limit");
        }
        if(!form.getSharingPath().equals(PENGYOUQUAN) && !form.getSharingPath().equals(WEIXINQUN) && !form.getSharingPath().equals(BOTH_PATH)){
            throw new InvalidRequestException("invalidPath","invalid sharing path");
        }

        GiftMoney giftMoney = new GiftMoney();
        BeanUtils.copyProperties(form,giftMoney);
        giftMoney.setNumber(SequenceNumUtils.generateNum());
        giftMoney.setRemainAmount(giftMoney.getTotalAmount());
        giftMoney.setCreateBy(sessionContext.getUser().getId());
        giftMoneyService.create(giftMoney);
        return new ResponseView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public ResponseView update(@Valid @RequestBody GiftMoneyUpdateForm form){
        GiftMoney giftMoney = giftMoneyService.getById(form.getId());
        if(Objects.isNull(giftMoney)){
            throw new ResourceNotFoundException("giftMoney not exists");
        }
        BeanUtils.copyProperties(form,giftMoney);
        giftMoney.setUpdateBy(sessionContext.getUser().getId());
        giftMoneyService.update(giftMoney);
        return new ResponseView();
    }

    @RequestMapping(value = "/status",method = RequestMethod.PUT)
    public ResponseView status(@Valid @RequestBody GiftMoneyStatusForm form){
        GiftMoney giftMoney = giftMoneyService.getById(form.getId());
        if(Objects.isNull(giftMoney)){
            throw new ResourceNotFoundException("giftMoney not exists");
        }
        BeanUtils.copyProperties(form,giftMoney);
        giftMoney.setUpdateBy(sessionContext.getUser().getId());
        giftMoneyService.updateStatus(giftMoney);
        return new ResponseView();
    }
}
