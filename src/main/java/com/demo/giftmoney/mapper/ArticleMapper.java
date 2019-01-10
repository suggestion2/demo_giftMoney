package com.demo.giftmoney.mapper;

import com.demo.giftmoney.domain.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArticleMapper {

    Article selectById(Integer id);

    Article select(Map<String, Object> map);

    List<Article> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(Article article);

    int update(Article article);

    int deleteById(Integer id);
}