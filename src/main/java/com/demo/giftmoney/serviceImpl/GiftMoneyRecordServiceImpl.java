package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.domain.GiftMoneyRecord;
import com.demo.giftmoney.service.GiftMoneyRecordService;
import com.demo.giftmoney.mapper.GiftMoneyRecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GiftMoneyRecordServiceImpl implements GiftMoneyRecordService{

    @Autowired
    private GiftMoneyRecordMapper giftMoneyRecordMapper;

    @Override
    public GiftMoneyRecord getById(Integer id){
        return giftMoneyRecordMapper.selectById(id);
    }
    @Override
    public GiftMoneyRecord select(Map<String, Object> map){
        return giftMoneyRecordMapper.select(map);
    }

    @Override
    public List<GiftMoneyRecord> selectList(Map<String, Object> map){
        return giftMoneyRecordMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return giftMoneyRecordMapper.selectCount(map);
    }

    @Override
    public int create(GiftMoneyRecord giftMoneyRecord){
        return giftMoneyRecordMapper.insert(giftMoneyRecord);
    }

    @Override
    public int update(GiftMoneyRecord giftMoneyRecord){
        return giftMoneyRecordMapper.update(giftMoneyRecord);
    }

    @Override
    public int deleteById(Integer id){
        return giftMoneyRecordMapper.deleteById(id);
    }
}