package com.demo.giftmoney.mapper;

import com.demo.giftmoney.domain.ArticleRecord;
import com.demo.giftmoney.response.ArticleRecordListItemView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArticleRecordMapper {

    ArticleRecord selectById(Integer id);

    ArticleRecord select(Map<String, Object> map);

    List<ArticleRecord> selectList(Map<String, Object> map);

    List<ArticleRecordListItemView> selectViewList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(ArticleRecord articleRecord);

    int update(ArticleRecord articleRecord);

    int deleteById(Integer id);
}