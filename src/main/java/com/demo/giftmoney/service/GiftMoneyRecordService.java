package com.demo.giftmoney.service;

import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.domain.GiftMoneyRecord;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GiftMoneyRecordService {
    GiftMoneyRecord getById(Integer id);

    GiftMoneyRecord select(Map<String, Object> map);

    List<GiftMoneyRecord> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    void drawGiftMoney(Integer customerId,String openId, String customerName, Integer articleId, String articleTitle, GiftMoney giftMoney, Integer type) throws Exception;

    int create(GiftMoneyRecord giftMoneyRecord);

    int update(GiftMoneyRecord giftMoneyRecord);

    int deleteById(Integer id);
}