package com.demo.giftmoney.mapper;

import com.demo.giftmoney.domain.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CustomerMapper {

    Customer selectById(Integer id);

    Customer select(Map<String, Object> map);

    List<Customer> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(Customer customer);

    int update(Customer customer);

    int deleteById(Integer id);
}