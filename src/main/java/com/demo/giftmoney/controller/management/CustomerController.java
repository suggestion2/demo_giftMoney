package com.demo.giftmoney.controller.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
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
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public CustomerListView list(@Valid @RequestBody CustomerListForm form){
        return new CustomerListView(customerService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public Customer detail(@PathVariable Integer id){
        return customerService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody CustomerCreateForm form){
        Customer customer = new Customer();
        BeanUtils.copyProperties(form,customer);
        customerService.create(customer);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody CustomerUpdateForm form){
        Customer customer = customerService.getById(form.getId());
        if(Objects.isNull(customer)){
            throw new ResourceNotFoundException("customer not exists");
        }
        BeanUtils.copyProperties(form,customer);
        customerService.update(customer);
        return new SuccessView();
    }
}
