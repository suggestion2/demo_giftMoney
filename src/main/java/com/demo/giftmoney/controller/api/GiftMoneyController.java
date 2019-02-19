package com.demo.giftmoney.controller.api;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.interceptor.LoginRequired;
import com.demo.giftmoney.interceptor.WechatLoginRequired;
import com.demo.giftmoney.request.GiftMoneyCreateForm;
import com.demo.giftmoney.request.GiftMoneyListForm;
import com.demo.giftmoney.request.GiftMoneyStatusForm;
import com.demo.giftmoney.request.GiftMoneyUpdateForm;
import com.demo.giftmoney.response.GiftMoneyListView;
import com.demo.giftmoney.service.GiftMoneyRecordService;
import com.demo.giftmoney.service.GiftMoneyService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
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

@RestController("giftMoneyApiController")
@RequestMapping(value = "/api/giftMoney")
@WechatLoginRequired
public class GiftMoneyController {

    private static final Logger logger = LoggerFactory.getLogger(GiftMoneyController.class);

    @Autowired
    private GiftMoneyService giftMoneyService;

    @Autowired
    private GiftMoneyRecordService giftMoneyRecordService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = "/draw",method = RequestMethod.GET)
    public ResponseView draw() throws Exception {
        GiftMoney giftMoney;
        if(Objects.isNull(sessionContext.getGiftMoneyId()) || Objects.isNull(giftMoney = giftMoneyService.getById(sessionContext.getGiftMoneyId()))){
            throw new ResourceNotFoundException("giftmoney not found");
        }
        giftMoneyRecordService.drawGiftMoney(sessionContext.getCustomerId(),sessionContext.getOpenId(),sessionContext.getCustomerName(),sessionContext.getArticleId(),sessionContext.getArticleTitle(),giftMoney,READ_TYPE);
        return new ResponseView();
    }
}
