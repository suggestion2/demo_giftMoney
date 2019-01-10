package com.demo.giftmoney.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ArticleRecordUpdateForm {

    @NotNull
    private Integer id;
    @NotNull
    private Integer articleId;
    @NotNull
    private Integer customerId;
    @NotNull
    private Integer parentId;
    @NotNull
    private Integer sourceCustomerId;
    @NotEmpty
    private String customerNickname;
    @NotEmpty
    private String sourceCustomerNickname;
    @NotNull
    private Integer degree;
    @NotNull
    private Long duration;
    @NotNull
    private Integer browseCount;
    @NotNull
    private Integer pageView;
    @NotNull
    private Integer sharing;
    @NotNull
    private Integer sharingPath1Count;
    @NotNull
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
    public Integer getDegree() {
    return degree;
    }

    public void setDegree(Integer degree) {
    this.degree = degree;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getBrowseCount() {
    return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
    this.browseCount = browseCount;
    }
    public Integer getPageView() {
    return pageView;
    }

    public void setPageView(Integer pageView) {
    this.pageView = pageView;
    }
    public Integer getSharing() {
    return sharing;
    }

    public void setSharing(Integer sharing) {
    this.sharing = sharing;
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