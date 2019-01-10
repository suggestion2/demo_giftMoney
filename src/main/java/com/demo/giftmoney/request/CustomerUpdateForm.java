package com.demo.giftmoney.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerUpdateForm {

    @NotNull
    private Integer id;
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String province;
    @NotEmpty
    private String city;
    @NotEmpty
    private String county;
    @NotEmpty
    private String headimgurl;
    @NotEmpty
    private String openid;
    @NotEmpty
    private String unionid;
    @NotNull
    private Integer parentId;
    @NotEmpty
    private String parentNickname;
    @NotNull
    private Integer articleId;
    @NotNull
    private Integer articleRecordId;
    @NotNull
    private Integer level;

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
    public String getOpenid() {
    return openid;
    }

    public void setOpenid(String openid) {
    this.openid = openid;
    }
    public String getUnionid() {
    return unionid;
    }

    public void setUnionid(String unionid) {
    this.unionid = unionid;
    }
    public Integer getParentId() {
    return parentId;
    }

    public void setParentId(Integer parentId) {
    this.parentId = parentId;
    }
    public String getParentNickname() {
    return parentNickname;
    }

    public void setParentNickname(String parentNickname) {
    this.parentNickname = parentNickname;
    }
    public Integer getArticleId() {
    return articleId;
    }

    public void setArticleId(Integer articleId) {
    this.articleId = articleId;
    }
    public Integer getArticleRecordId() {
    return articleRecordId;
    }

    public void setArticleRecordId(Integer articleRecordId) {
    this.articleRecordId = articleRecordId;
    }
    public Integer getLevel() {
    return level;
    }

    public void setLevel(Integer level) {
    this.level = level;
    }

}