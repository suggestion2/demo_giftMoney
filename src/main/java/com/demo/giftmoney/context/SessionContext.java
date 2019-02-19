package com.demo.giftmoney.context;

import com.demo.giftmoney.domain.Customer;
import com.demo.giftmoney.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
public class SessionContext {

    @Autowired
    private HttpSession httpSession;

    public void setUser(User user){
        httpSession.setAttribute("user",user);
    }

    public User getUser(){
        return httpSession.getAttribute("user") == null ? null : (User)httpSession.getAttribute("user");
    }

    public void setCustomerName(String name){
        httpSession.setAttribute("name",name);
    }

    public String getCustomerName(){
        return httpSession.getAttribute("name") == null ? null : (String) httpSession.getAttribute("name");
    }

    public void setCustomerId(Integer customerId){
        httpSession.setAttribute("customerId",customerId);
    }

    public Integer getCustomerId(){
        return httpSession.getAttribute("customerId") == null ? null : (Integer) httpSession.getAttribute("customerId");
    }

    public void setOpenId(String openId){
        httpSession.setAttribute("openId",openId);
    }

    public String getOpenId(){
        return httpSession.getAttribute("openId") == null ? null : (String) httpSession.getAttribute("openId");
    }

    public void setArticleTitle(String articleTitle){
        httpSession.setAttribute("articleTitle",articleTitle);
    }

    public String getArticleTitle(){
        return httpSession.getAttribute("articleTitle") == null ? null : (String) httpSession.getAttribute("articleTitle");
    }

    public void setArticleId(int articleId){
        httpSession.setAttribute("articleId",articleId);
    }

    public Integer getArticleId(){
        return httpSession.getAttribute("articleId") == null ? null : (Integer) httpSession.getAttribute("articleId");
    }

    public void setGiftMoneyId(int giftMoneyId){
        httpSession.setAttribute("giftMoneyId",giftMoneyId);
    }

    public Integer getGiftMoneyId(){
        return httpSession.getAttribute("giftMoneyId") == null ? null : (Integer) httpSession.getAttribute("giftMoneyId");
    }

    public void setBeginReadTime(){
        httpSession.setAttribute("beginReadTime",new Date().getTime());
    }

    public Long getBeginReadTime(){
        return httpSession.getAttribute("beginReadTime") == null ? null : (Long) httpSession.getAttribute("beginReadTime");
    }

    public void setLastShareTime(){
        httpSession.setAttribute("lastShareTime",new Date().getTime());
    }

    public Long getLastShareTime(){
        return httpSession.getAttribute("lastShareTime") == null ? null : (Long) httpSession.getAttribute("lastShareTime");
    }

    public void logout(){
        httpSession.invalidate();
    }
}
