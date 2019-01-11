package com.demo.giftmoney.response;

import java.util.Objects;

public class CustomerListItemView {
    private String nickname;
    private String area;
    private String parentNickname;
    private Integer giftMoneyCount;
    private Integer giftMoneyAmount;
    private Integer sharingPath1Count;
    private Integer sharingPath2Count;
    private Integer directPV;
    private Integer directUV;
    private Integer status;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getParentNickname() {
        return parentNickname;
    }

    public void setParentNickname(String parentNickname) {
        this.parentNickname = parentNickname;
    }

    public Integer getGiftMoneyCount() {
        return giftMoneyCount;
    }

    public void setGiftMoneyCount(Integer giftMoneyCount) {
        this.giftMoneyCount = giftMoneyCount;
    }

    public Integer getGiftMoneyAmount() {
        return giftMoneyAmount;
    }

    public void setGiftMoneyAmount(Integer giftMoneyAmount) {
        this.giftMoneyAmount = giftMoneyAmount;
    }

    public Integer getSharingPath1Count() {
        return sharingPath1Count;
    }

    public void setSharingPath1Count(Integer sharingPath1Count) {
        this.sharingPath1Count = sharingPath1Count;
    }

    public Integer getSharingPath2Count() {
        return sharingPath2Count;
    }

    public void setSharingPath2Count(Integer sharingPath2Count) {
        this.sharingPath2Count = sharingPath2Count;
    }

    public Integer getDirectPV() {
        return directPV;
    }

    public void setDirectPV(Integer directPV) {
        this.directPV = directPV;
    }

    public Integer getDirectUV() {
        return directUV;
    }

    public void setDirectUV(Integer directUV) {
        this.directUV = directUV;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
