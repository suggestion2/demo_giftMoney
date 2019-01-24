package com.demo.giftmoney.controller.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.rest.view.SuccessView;
import com.demo.giftmoney.domain.GiftMoneyRecord;
import com.demo.giftmoney.service.GiftMoneyRecordService;
import com.demo.giftmoney.request.GiftMoneyRecordCreateForm;
import com.demo.giftmoney.request.GiftMoneyRecordUpdateForm;
import com.demo.giftmoney.request.GiftMoneyRecordListForm;
import com.demo.giftmoney.response.GiftMoneyRecordListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.demo.giftmoney.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/management/giftMoney/record")
public class GiftMoneyRecordController {

    private static final Logger logger = LoggerFactory.getLogger(GiftMoneyRecordController.class);

    @Autowired
    private GiftMoneyRecordService giftMoneyRecordService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public GiftMoneyRecordListView list(@Valid @RequestBody GiftMoneyRecordListForm form){
        return new GiftMoneyRecordListView(giftMoneyRecordService.selectList(form.getQueryMap()));
    }
}
