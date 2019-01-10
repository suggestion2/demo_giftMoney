package com.demo.giftmoney.mapper;

import com.demo.giftmoney.domain.GiftMoneyRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GiftMoneyRecordMapper {

    GiftMoneyRecord selectById(Integer id);

    GiftMoneyRecord select(Map<String, Object> map);

    List<GiftMoneyRecord> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(GiftMoneyRecord giftMoneyRecord);

    int update(GiftMoneyRecord giftMoneyRecord);

    int deleteById(Integer id);
}