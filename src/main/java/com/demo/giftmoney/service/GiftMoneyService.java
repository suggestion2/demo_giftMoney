package com.demo.giftmoney.service;

import com.demo.giftmoney.domain.GiftMoney;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GiftMoneyService {
    GiftMoney getById(Integer id);

    GiftMoney select(Map<String, Object> map);

    List<GiftMoney> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(GiftMoney giftMoney);

    int update(GiftMoney giftMoney);

    int updateStatus(GiftMoney giftMoney);

    int deleteById(Integer id);
}