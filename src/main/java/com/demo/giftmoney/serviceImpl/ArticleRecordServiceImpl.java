package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.domain.Article;
import com.demo.giftmoney.domain.ArticleRecord;
import com.demo.giftmoney.domain.Customer;
import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.mapper.ArticleShareParams;
import com.demo.giftmoney.mapper.CustomerMapper;
import com.demo.giftmoney.request.ArticleReadTimeForm;
import com.demo.giftmoney.response.ArticleRecordListItemView;
import com.demo.giftmoney.service.ArticleRecordService;
import com.demo.giftmoney.mapper.ArticleRecordMapper;
import com.demo.giftmoney.service.GiftMoneyRecordService;
import com.demo.giftmoney.service.GiftMoneyService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.demo.giftmoney.constants.ArticleConstants.BASE_DEGREE;
import static com.demo.giftmoney.constants.GiftMoneyConstants.SHARE_TYPE;

@Service
public class ArticleRecordServiceImpl implements ArticleRecordService{

    @Autowired
    private ArticleRecordMapper articleRecordMapper;

    @Autowired
    private GiftMoneyService giftMoneyService;

    @Autowired
    private GiftMoneyRecordService giftMoneyRecordService;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public ArticleRecord getById(Integer id){
        return articleRecordMapper.selectById(id);
    }

    @Override
    public ArticleRecord getByCustomerArticle(Integer customerId, Integer articleId) {
        Map<String,Object> query = new HashMap<>();
        query.put("customerId",customerId);
        query.put("articleId",articleId);
        return articleRecordMapper.select(query);
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
    @Async
    public void share(Integer articleRecordId,Integer path) {
        ArticleShareParams params = new ArticleShareParams(articleRecordId,path);
        articleRecordMapper.share(params);
    }

    @Override
    @Async
    @Transactional
    public void read(Integer customerId,String openId,String customerName, Integer articleId,String articleTitle,Integer giftMoneyId, Integer sourceCustomerId) throws Exception {
        int result;
        ArticleRecord articleRecord = this.getByCustomerArticle(customerId,articleId);
        if(Objects.nonNull(articleRecord)){
            result = articleRecordMapper.readUpdate(articleRecord.getId());
            if(result == 0){
                throw new RuntimeException("update articleRecord fail : articleRecordId " + articleRecord.getId());
            }
            return;
        }
        articleRecord = new ArticleRecord();
        articleRecord.setCustomerId(customerId);
        articleRecord.setCustomerNickname(customerName);
        articleRecord.setArticleId(articleId);
        articleRecord.setDegree(BASE_DEGREE);

        ArticleRecord parentRecord;
        if(Objects.nonNull(sourceCustomerId) && !customerId.equals(sourceCustomerId) && Objects.nonNull(parentRecord = this.getByCustomerArticle(sourceCustomerId,articleId))){
            Customer parent = customerMapper.selectById(sourceCustomerId);
            articleRecord.setParentId(parentRecord.getId());
            articleRecord.setSourceCustomerId(parent.getId());
            articleRecord.setSourceCustomerNickname(parent.getNickname());
            articleRecord.setDegree(articleRecord.getDegree() + 1);

            GiftMoney giftMoney = giftMoneyService.getById(giftMoneyId);
            if(Objects.nonNull(giftMoney)){
                giftMoneyRecordService.drawGiftMoney(parent.getId(),parent.getOpenid(),parent.getNickname(),articleId,articleTitle,giftMoney,SHARE_TYPE);
            }
        }

        result = articleRecordMapper.insert(articleRecord);
        if(result == 0){
            throw new RuntimeException("insert articleRecord fail : customerId " + customerId + " articleId " + articleId);
        }
    }

    @Override
    @Async
    public void addDuration(Integer customerId, Integer articleId, Long duration) {
        ArticleRecord articleRecord = this.getByCustomerArticle(customerId,articleId);
        articleRecordMapper.readDuration(new ArticleReadTimeForm(articleRecord.getId(),duration));
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