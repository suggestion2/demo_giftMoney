package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.service.GiftMoneyService;
import com.demo.giftmoney.mapper.GiftMoneyMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GiftMoneyServiceImpl implements GiftMoneyService{

    @Autowired
    private GiftMoneyMapper giftMoneyMapper;

    @Override
    public GiftMoney getById(Integer id){
        return giftMoneyMapper.selectById(id);
    }
    @Override
    public GiftMoney select(Map<String, Object> map){
        return giftMoneyMapper.select(map);
    }

    @Override
    public List<GiftMoney> selectList(Map<String, Object> map){
        return giftMoneyMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return giftMoneyMapper.selectCount(map);
    }

    @Override
    public int create(GiftMoney giftMoney){
        return giftMoneyMapper.insert(giftMoney);
    }

    @Override
    public int update(GiftMoney giftMoney){
        return giftMoneyMapper.update(giftMoney);
    }

    @Override
    public int updateStatus(GiftMoney giftMoney) {
        return giftMoneyMapper.updateStatus(giftMoney);
    }

    @Override
    public int deleteById(Integer id){
        return giftMoneyMapper.deleteById(id);
    }
}