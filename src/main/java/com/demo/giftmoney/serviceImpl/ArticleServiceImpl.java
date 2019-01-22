package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.domain.Article;
import com.demo.giftmoney.response.ArticleListItemView;
import com.demo.giftmoney.service.ArticleService;
import com.demo.giftmoney.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article getById(Integer id){
        return articleMapper.selectById(id);
    }

    @Override
    public Article getByTitle(String title) {
        return articleMapper.select(Collections.singletonMap("title",title));
    }

    @Override
    public Article select(Map<String, Object> map){
        return articleMapper.select(map);
    }

    @Override
    public List<Article> selectList(Map<String, Object> map){
        return articleMapper.selectList(map);
    }

    @Override
    public List<ArticleListItemView> selectViewList(Map<String, Object> map) {
        return articleMapper.selectViewList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return articleMapper.selectCount(map);
    }

    @Override
    public int create(Article article){
        return articleMapper.insert(article);
    }

    @Override
    public int update(Article article){
        return articleMapper.update(article);
    }

    @Override
    public int updateStatus(Article article) {
        return articleMapper.updateStatus(article);
    }

    @Override
    public int deleteById(Integer id){
        return articleMapper.deleteById(id);
    }
}