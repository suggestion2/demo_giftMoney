package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.domain.GiftMoney;
import com.demo.giftmoney.domain.GiftMoneyRecord;
import com.demo.giftmoney.mapper.GiftMoneyDeductBalanceParams;
import com.demo.giftmoney.mapper.GiftMoneyMapper;
import com.demo.giftmoney.service.GiftMoneyRecordService;
import com.demo.giftmoney.mapper.GiftMoneyRecordMapper;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.platform.wechat.form.WeChatGiftMoneyForm;
import com.sug.core.platform.wechat.response.WeChatGiftMoneyResponse;
import com.sug.core.platform.wechat.service.WeChatPayService;
import com.sug.core.util.BigDecimalUtils;
import com.sug.core.util.SequenceNumUtils;
import com.sug.core.util.UUIDUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.demo.giftmoney.constants.GiftMoneyConstants.READ_TYPE;
import static com.demo.giftmoney.constants.GiftMoneyConstants.SHARE_TYPE;

@Service
public class GiftMoneyRecordServiceImpl implements GiftMoneyRecordService{

    @Autowired
    private GiftMoneyRecordMapper giftMoneyRecordMapper;

    @Autowired
    private GiftMoneyMapper giftMoneyMapper;

    @Autowired
    private WeChatPayService weChatPayService;

    @Override
    public GiftMoneyRecord getById(Integer id){
        return giftMoneyRecordMapper.selectById(id);
    }
    @Override
    public GiftMoneyRecord select(Map<String, Object> map){
        return giftMoneyRecordMapper.select(map);
    }

    @Override
    public GiftMoneyRecord getUnique(Integer customerId, Integer articleId) {
        Map<String,Object> query = new HashMap<>();
        query.put("customerId",customerId);
        query.put("articleId",articleId);
        return giftMoneyRecordMapper.select(query);
    }


    @Override
    public List<GiftMoneyRecord> selectList(Map<String, Object> map){
        return giftMoneyRecordMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return giftMoneyRecordMapper.selectCount(map);
    }

//    @Async
    @Override
    public void drawGiftMoney(Integer customerId,String openId, String customerName, Integer articleId, String articleTitle, GiftMoney giftMoney, Integer type) throws Exception {
        String number = SequenceNumUtils.generateShortNum();

        GiftMoneyRecord giftMoneyRecord = new GiftMoneyRecord();
        giftMoneyRecord.setNumber(number);
        giftMoneyRecord.setCustomerId(customerId);
        giftMoneyRecord.setCustomerNickname(customerName);
        giftMoneyRecord.setArticleId(articleId);
        giftMoneyRecord.setArticleTitle(articleTitle);
        giftMoneyRecord.setGiftMoneyId(giftMoney.getId());
        giftMoneyRecord.setType(type);
        if(type.equals(SHARE_TYPE)){
            if(giftMoney.getRemainAmount().compareTo(giftMoney.getSharingLimit()) < 0){
                throw new InvalidRequestException("insufficientBalance","insufficient balance");
            }
            giftMoneyRecord.setAmount(giftMoney.getSharingLimit());
        }
        if(type.equals(READ_TYPE)){
            if(giftMoney.getRemainAmount().compareTo(giftMoney.getLow()) < 0){
                throw new InvalidRequestException("insufficientBalance","insufficient balance");
            }
            if(giftMoney.getRemainAmount().compareTo(giftMoney.getUpper()) <= 0){
                giftMoneyRecord.setAmount(giftMoney.getRemainAmount());
            }else {
                int seed = ThreadLocalRandom.current().nextInt(1,100);
                giftMoneyRecord.setAmount(BigDecimalUtils.add(giftMoney.getLow(),(BigDecimalUtils.multiply(BigDecimalUtils.subtract(giftMoney.getUpper(),giftMoney.getLow()),new BigDecimal(seed / 100.0d)))));
            }
        }

        WeChatGiftMoneyForm form = new WeChatGiftMoneyForm();
        form.setMch_billno(number);
        form.setRe_openid(openId);
        form.setTotal_amount(String.valueOf(BigDecimalUtils.multiply(giftMoneyRecord.getAmount().setScale(2,BigDecimal.ROUND_UP),100).intValue()));
        form.setTotal_num("1");
        form.setWishing(giftMoney.getTitle());
        form.setAct_name(giftMoney.getTitle());
        form.setRemark("赞云科技");
        if(Integer.valueOf(form.getTotal_amount()) < 100){
            form.setScene_id("PRODUCT_1");
        }

        WeChatGiftMoneyResponse response = weChatPayService.normalGiftMoney(form);
        giftMoneyRecord.setWechatId(response.getSend_listid());

        if(giftMoneyMapper.deductBalance(new GiftMoneyDeductBalanceParams(giftMoney.getId(),giftMoneyRecord.getAmount())) == 0){
            throw new InvalidRequestException("deduct balance fail","insufficient balance");
        }

        giftMoneyRecordMapper.insert(giftMoneyRecord);
    }

    @Override
    public int create(GiftMoneyRecord giftMoneyRecord){
        return giftMoneyRecordMapper.insert(giftMoneyRecord);
    }

    @Override
    public int update(GiftMoneyRecord giftMoneyRecord){
        return giftMoneyRecordMapper.update(giftMoneyRecord);
    }

    @Override
    public int deleteById(Integer id){
        return giftMoneyRecordMapper.deleteById(id);
    }
}