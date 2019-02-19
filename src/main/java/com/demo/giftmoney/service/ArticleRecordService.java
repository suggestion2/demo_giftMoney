package com.demo.giftmoney.service;

import com.demo.giftmoney.domain.ArticleRecord;
import com.demo.giftmoney.domain.Customer;
import com.demo.giftmoney.response.ArticleRecordListItemView;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface ArticleRecordService {
    ArticleRecord getById(Integer id);

    ArticleRecord getByCustomerArticle(Integer customerId,Integer articleId);

    ArticleRecord select(Map<String, Object> map);

    List<ArticleRecord> selectList(Map<String, Object> map);

    List<ArticleRecordListItemView> selectViewList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(ArticleRecord articleRecord);

    void share(Integer articleRecordId,Integer path);

    void read(Integer customerId,String openId, String customerName, Integer articleId,String articleTitle,Integer giftMoneyId, Integer sourceCustomerId) throws Exception;

    int update(ArticleRecord articleRecord);

    int deleteById(Integer id);
}