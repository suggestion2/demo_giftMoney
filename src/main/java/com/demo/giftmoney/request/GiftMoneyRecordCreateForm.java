package com.demo.giftmoney.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GiftMoneyRecordCreateForm {

    @NotNull
    private Integer wechatId;
    @NotNull
    private Integer giftMoneyId;
    @NotNull
    private Integer articleId;
    @NotNull
    private Integer customerId;
    @NotEmpty
    private String articleTitle;
    @NotEmpty
    private String customerNickname;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Integer type;
    @NotNull
    private Date sendTime;
    @NotNull
    private Date receiveTime;
    @NotNull
    private Integer receiveStatus;
    @NotNull
    private Integer refundStatus;
    @NotNull
    private Date refundTime;
    @NotEmpty
    private String errorCode;
    @NotEmpty
    private String failReason;

    public Integer getWechatId() {
    return wechatId;
    }

    public void setWechatId(Integer wechatId) {
    this.wechatId = wechatId;
    }
    public Integer getGiftMoneyId() {
    return giftMoneyId;
    }

    public void setGiftMoneyId(Integer giftMoneyId) {
    this.giftMoneyId = giftMoneyId;
    }
    public Integer getArticleId() {
    return articleId;
    }

    public void setArticleId(Integer articleId) {
    this.articleId = articleId;
    }
    public Integer getCustomerId() {
    return customerId;
    }

    public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
    }
    public String getArticleTitle() {
    return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
    this.articleTitle = articleTitle;
    }
    public String getCustomerNickname() {
    return customerNickname;
    }

    public void setCustomerNickname(String customerNickname) {
    this.customerNickname = customerNickname;
    }
    public BigDecimal getAmount() {
    return amount;
    }

    public void setAmount(BigDecimal amount) {
    this.amount = amount;
    }
    public Integer getType() {
    return type;
    }

    public void setType(Integer type) {
    this.type = type;
    }
    public Date getSendTime() {
    return sendTime;
    }

    public void setSendTime(Date sendTime) {
    this.sendTime = sendTime;
    }
    public Date getReceiveTime() {
    return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
    this.receiveTime = receiveTime;
    }
    public Integer getReceiveStatus() {
    return receiveStatus;
    }

    public void setReceiveStatus(Integer receiveStatus) {
    this.receiveStatus = receiveStatus;
    }
    public Integer getRefundStatus() {
    return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
    this.refundStatus = refundStatus;
    }
    public Date getRefundTime() {
    return refundTime;
    }

    public void setRefundTime(Date refundTime) {
    this.refundTime = refundTime;
    }
    public String getErrorCode() {
    return errorCode;
    }

    public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
    }
    public String getFailReason() {
    return failReason;
    }

    public void setFailReason(String failReason) {
    this.failReason = failReason;
    }

}