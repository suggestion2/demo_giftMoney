package com.demo.giftmoney.service;

import com.demo.giftmoney.domain.Article;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface ArticleService {
    Article getById(Integer id);

    Article select(Map<String, Object> map);

    List<Article> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(Article article);

    int update(Article article);

    int deleteById(Integer id);
}