package com.demo.giftmoney.service;

import com.demo.giftmoney.domain.Customer;
import com.demo.giftmoney.response.CustomerListItemView;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface CustomerService {
    Customer getById(Integer id);

    Customer select(Map<String, Object> map);

    List<Customer> selectList(Map<String, Object> map);

    List<CustomerListItemView> selectItemViewList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(Customer customer);

    int update(Customer customer);

    int updateStatus(Customer customer);

    int deleteById(Integer id);
}