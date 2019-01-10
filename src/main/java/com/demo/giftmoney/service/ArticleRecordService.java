package com.demo.giftmoney.service;

import com.demo.giftmoney.domain.ArticleRecord;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface ArticleRecordService {
    ArticleRecord getById(Integer id);

    ArticleRecord select(Map<String, Object> map);

    List<ArticleRecord> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(ArticleRecord articleRecord);

    int update(ArticleRecord articleRecord);

    int deleteById(Integer id);
}