package com.demo.giftmoney.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GiftMoneyCreateForm {

    @NotEmpty
    private String title;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal totalAmount;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal low;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal upper;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private Integer areaId;
    private String province;
    private String city;
    private String county;
    @NotNull
    private Integer sharingPath;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal sharingLimit;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getUpper() {
        return upper;
    }

    public void setUpper(BigDecimal upper) {
        this.upper = upper;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Integer getSharingPath() {
        return sharingPath;
    }

    public void setSharingPath(Integer sharingPath) {
        this.sharingPath = sharingPath;
    }

    public BigDecimal getSharingLimit() {
        return sharingLimit;
    }

    public void setSharingLimit(BigDecimal sharingLimit) {
        this.sharingLimit = sharingLimit;
    }
}