package com.demo.giftmoney.context;

import com.demo.giftmoney.domain.Customer;
import com.demo.giftmoney.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

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

    public void setCustomerId(int customerId){
        httpSession.setAttribute("customerId",customerId);
    }

    public Integer getCustomerId(){
        return httpSession.getAttribute("customerId") == null ? null : (Integer) httpSession.getAttribute("customerId");
    }

    public void logout(){
        httpSession.invalidate();
    }
}
