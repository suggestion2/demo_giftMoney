package com.demo.giftmoney.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GiftMoneyUpdateForm {

    @NotNull
    private Integer id;
    @NotEmpty
    private String number;
    @NotEmpty
    private String title;
    @NotNull
    private BigDecimal totalAmount;
    @NotNull
    private BigDecimal remainAmount;
    @NotNull
    private BigDecimal low;
    @NotNull
    private BigDecimal upper;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private Integer areaId;
    @NotEmpty
    private String area;
    @NotNull
    private Integer sharingPath;
    @NotNull
    private BigDecimal sharingLimit;

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }
    public String getNumber() {
    return number;
    }

    public void setNumber(String number) {
    this.number = number;
    }
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
    public BigDecimal getRemainAmount() {
    return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
    this.remainAmount = remainAmount;
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
    public String getArea() {
    return area;
    }

    public void setArea(String area) {
    this.area = area;
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