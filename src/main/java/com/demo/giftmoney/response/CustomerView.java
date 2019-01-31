package com.demo.giftmoney.response;

import com.demo.giftmoney.domain.Customer;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class CustomerView {
    private Integer id;
    private String nickname;
    private String province;
    private String city;
    private String county;
    private String headimgurl;
    private Integer level;

    private CustomerView(){

    }

    public static CustomerView build(Customer customer){
        CustomerView view = new CustomerView();
        BeanUtils.copyProperties(customer,view);
        return view;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
