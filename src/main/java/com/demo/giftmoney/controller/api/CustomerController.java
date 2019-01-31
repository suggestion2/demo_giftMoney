package com.demo.giftmoney.controller.api;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.domain.Customer;
import com.demo.giftmoney.interceptor.LoginRequired;
import com.demo.giftmoney.request.CustomerListForm;
import com.demo.giftmoney.request.CustomerLoginForm;
import com.demo.giftmoney.request.CustomerStatusForm;
import com.demo.giftmoney.response.CustomerListView;
import com.demo.giftmoney.response.CustomerView;
import com.demo.giftmoney.service.CustomerService;
import com.demo.giftmoney.service.UserService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.platform.wechat.entity.WeChatOAuthEntity;
import com.sug.core.platform.wechat.response.WeChatUserInfoResponse;
import com.sug.core.platform.wechat.service.WeChatAuthService;
import com.sug.core.rest.view.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

import static com.demo.giftmoney.constants.CommonConstants.LIST;
import static com.demo.giftmoney.constants.CommonConstants.LOGIN;
import static com.sug.core.platform.wechat.constants.WeChatParams.MP_TYPE;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WeChatAuthService weChatAuthService;

    @RequestMapping(value = LOGIN,method = RequestMethod.POST)
    public CustomerView login(@Valid @RequestBody CustomerLoginForm form) throws Exception {
        WeChatOAuthEntity entity = weChatAuthService.getOAuth(form.getCode(),MP_TYPE);

        Customer customer = customerService.getByOpenId(entity.getOpenid());
        if(Objects.nonNull(customer)){
            sessionContext.setCustomerId(customer.getId());
            return CustomerView.build(customer);
        }

        WeChatUserInfoResponse response = weChatAuthService.getUserInfo(entity);
        customer = new Customer();
        BeanUtils.copyProperties(response,customer);

        customer.setArticleId(form.getArticleId());
        customer.setArticleRecordId(0);
        customer.setLevel(1);
        customer.setParentId(0);
        customer.setParentNickname("");
        customer.setCreateBy(0);

        if(Objects.nonNull(form.getArticleRecordId())){
            customer.setArticleRecordId(form.getArticleRecordId());
        }

        if(Objects.nonNull(form.getLevel())){
            customer.setLevel(form.getLevel());
        }

        if(Objects.nonNull(form.getCustomerId())){
            Customer parent = customerService.getById(form.getCustomerId());
            if(Objects.nonNull(parent)){
                customer.setParentId(parent.getId());
                customer.setParentNickname(parent.getNickname());
            }
        }

        customerService.create(customer);
        sessionContext.setCustomerId(customer.getId());
        return CustomerView.build(customer);
    }

}
