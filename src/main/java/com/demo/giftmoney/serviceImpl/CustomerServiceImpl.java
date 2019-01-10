package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.domain.Customer;
import com.demo.giftmoney.service.CustomerService;
import com.demo.giftmoney.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer getById(Integer id){
        return customerMapper.selectById(id);
    }
    @Override
    public Customer select(Map<String, Object> map){
        return customerMapper.select(map);
    }

    @Override
    public List<Customer> selectList(Map<String, Object> map){
        return customerMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return customerMapper.selectCount(map);
    }

    @Override
    public int create(Customer customer){
        return customerMapper.insert(customer);
    }

    @Override
    public int update(Customer customer){
        return customerMapper.update(customer);
    }

    @Override
    public int deleteById(Integer id){
        return customerMapper.deleteById(id);
    }
}