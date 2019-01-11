package com.demo.giftmoney.controller.management;

import com.demo.giftmoney.interceptor.LoginRequired;
import com.demo.giftmoney.request.CustomerStatusForm;
import com.demo.giftmoney.service.UserService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import com.demo.giftmoney.domain.Customer;
import com.demo.giftmoney.service.CustomerService;
import com.demo.giftmoney.request.CustomerCreateForm;
import com.demo.giftmoney.request.CustomerUpdateForm;
import com.demo.giftmoney.request.CustomerListForm;
import com.demo.giftmoney.response.CustomerListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.demo.giftmoney.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/management/customer")
@LoginRequired
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public CustomerListView list(@Valid @RequestBody CustomerListForm form){
        return new CustomerListView(customerService.selectItemViewList(form.getQueryMap()),customerService.selectCount(form.getQueryMap()));
    }

    @RequestMapping(value = "/status",method = RequestMethod.PUT)
    public ResponseView status(@Valid @RequestBody CustomerStatusForm form){
        Customer customer = customerService.getById(form.getId());
        if (Objects.isNull(customer)){
            throw new ResourceNotFoundException("customer not found");
        }
        if(customer.getStatus().equals(form.getStatus())){
            throw new InvalidRequestException("invalidStatus","invalid customer status to update");
        }
        customer.setStatus(form.getStatus());
        customer.setUpdateBy(userService.getCurrentUser().getId());
        customerService.updateStatus(customer);
        return new ResponseView();
    }
}
