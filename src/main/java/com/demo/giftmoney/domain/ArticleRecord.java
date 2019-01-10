package com.demo.giftmoney.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ArticleRecord {

    private Integer id;
    private Integer articleId;
    private Integer customerId;
    private Integer parentId;
    private Integer sourceCustomerId;
    private String customerNickname;
    private String sourceCustomerNickname;
    private Integer degree;
    private Long duration;
    private Integer browseCount;
    private Integer pageView;
    private Integer sharing;
    private Integer sharingPath1Count;
    private Integer sharingPath2Count;
    private Date createTime;
    private Date updateTime;
    private Integer createBy;
    private Integer updateBy;
    private Integer status;
    private Integer valid;

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
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

}