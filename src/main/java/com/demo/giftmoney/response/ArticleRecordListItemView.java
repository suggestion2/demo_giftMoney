package com.demo.giftmoney.response;

import java.math.BigDecimal;
import java.util.Objects;

public class ArticleRecordListItemView {
    private Integer id;
    private Integer articleId;
    private Integer customerId;
    private Integer parentId;
    private Integer sourceCustomerId;
    private String customerNickname;
    private String sourceCustomerNickname;
    private Integer level;
    private Long browseDuration;
    private Integer browseCount;
    private Integer directUV;
    private BigDecimal receiveAmount;
    private Integer sharingPath1Count;
    private Integer sharingPath2Count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSourceCustomerId() {
        return sourceCustomerId;
    }

    public void setSourceCustomerId(Integer sourceCustomerId) {
        this.sourceCustomerId = sourceCustomerId;
    }

    public String getCustomerNickname() {
        return customerNickname;
    }

    public void setCustomerNickname(String customerNickname) {
        this.customerNickname = customerNickname;
    }

    public String getSourceCustomerNickname() {
        return sourceCustomerNickname;
    }

    public void setSourceCustomerNickname(String sourceCustomerNickname) {
        this.sourceCustomerNickname = sourceCustomerNickname;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getBrowseDuration() {
        return browseDuration;
    }

    public void setBrowseDuration(Long browseDuration) {
        this.browseDuration = browseDuration;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getDirectUV() {
        return directUV;
    }

    public void setDirectUV(Integer directUV) {
        this.directUV = directUV;
    }

    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
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
}
