package com.demo.giftmoney.controller.api;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.domain.Article;
import com.demo.giftmoney.domain.ArticleRecord;
import com.demo.giftmoney.interceptor.WechatLoginRequired;
import com.demo.giftmoney.service.ArticleRecordService;
import com.demo.giftmoney.service.ArticleService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.platform.wechat.constants.WeChatJsInter;
import com.sug.core.platform.wechat.request.WeChatJsConfigForm;
import com.sug.core.platform.wechat.response.WeChatJsConfigResponse;
import com.sug.core.platform.wechat.service.WeChatJsParamsService;
import com.sug.core.rest.view.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.demo.giftmoney.constants.ArticleConstants.READ_DURATION;
import static com.demo.giftmoney.constants.ArticleConstants.SHARE_DURATION;

@RestController("commonApiController")
@RequestMapping(value = "/api")
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private WeChatJsParamsService weChatJsParamsService;

    @RequestMapping(value = "/shareParams",method = RequestMethod.POST)
    public WeChatJsConfigResponse getWechatShareJsParams(@Valid @RequestBody WeChatJsConfigForm form) throws Exception {
        List<String> interfaceList = new ArrayList<>();
        interfaceList.add(WeChatJsInter.TIMELINE_SHARE_2);
        interfaceList.add(WeChatJsInter.APPMESSAGE_SHARE_2);
        return weChatJsParamsService.getJsConfigParams(form.getUrl(),interfaceList);
    }
}
