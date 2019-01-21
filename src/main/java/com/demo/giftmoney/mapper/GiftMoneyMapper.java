package com.demo.giftmoney.mapper;

import com.demo.giftmoney.domain.GiftMoney;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GiftMoneyMapper {

    GiftMoney selectById(Integer id);

    GiftMoney select(Map<String, Object> map);

    List<GiftMoney> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(GiftMoney giftMoney);

    int update(GiftMoney giftMoney);

    int updateStatus(GiftMoney giftMoney);

    int deleteById(Integer id);
}