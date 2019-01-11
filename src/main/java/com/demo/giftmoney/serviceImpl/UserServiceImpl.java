package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.context.SessionContext;
import com.demo.giftmoney.domain.User;
import com.demo.giftmoney.service.UserService;
import com.demo.giftmoney.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SessionContext sessionContext;

    @Override
    public User getById(Integer id){
        return userMapper.selectById(id);
    }

    @Override
    public User getByName(String user) {
        return userMapper.select(Collections.singletonMap("name",user));
    }

    @Override
    public User getCurrentUser() {
        return sessionContext.getUser();
    }

    @Override
    public User select(Map<String, Object> map){
        return userMapper.select(map);
    }

    @Override
    public List<User> selectList(Map<String, Object> map){
        return userMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return userMapper.selectCount(map);
    }

    @Override
    public int create(User user){
        return userMapper.insert(user);
    }

    @Override
    public int update(User user){
        return userMapper.update(user);
    }

    @Override
    public int deleteById(Integer id){
        return userMapper.deleteById(id);
    }
}