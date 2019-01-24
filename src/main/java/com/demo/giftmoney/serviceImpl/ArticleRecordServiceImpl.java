package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.domain.ArticleRecord;
import com.demo.giftmoney.response.ArticleRecordListItemView;
import com.demo.giftmoney.service.ArticleRecordService;
import com.demo.giftmoney.mapper.ArticleRecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleRecordServiceImpl implements ArticleRecordService{

    @Autowired
    private ArticleRecordMapper articleRecordMapper;

    @Override
    public ArticleRecord getById(Integer id){
        return articleRecordMapper.selectById(id);
    }
    @Override
    public ArticleRecord select(Map<String, Object> map){
        return articleRecordMapper.select(map);
    }

    @Override
    public List<ArticleRecord> selectList(Map<String, Object> map){
        return articleRecordMapper.selectList(map);
    }

    @Override
    public List<ArticleRecordListItemView> selectViewList(Map<String, Object> map) {
        return articleRecordMapper.selectViewList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return articleRecordMapper.selectCount(map);
    }

    @Override
    public int create(ArticleRecord articleRecord){
        return articleRecordMapper.insert(articleRecord);
    }

    @Override
    public int update(ArticleRecord articleRecord){
        return articleRecordMapper.update(articleRecord);
    }

    @Override
    public int deleteById(Integer id){
        return articleRecordMapper.deleteById(id);
    }
}