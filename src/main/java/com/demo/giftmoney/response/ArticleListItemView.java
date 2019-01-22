package com.demo.giftmoney.response;

import java.math.BigDecimal;
import java.util.Objects;

public class ArticleListItemView {
    private Integer id;
    private String title;
    private String author;
    private Integer status;
    private Integer sharingCount;
    private Integer maxLevel;
    private Integer pv;
    private Integer uv;
    private BigDecimal receiveAmount;
    private Integer receiveCount;
    private Long totalDuration;
    private Long averageViewTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSharingCount() {
        return sharingCount;
    }

    public void setSharingCount(Integer sharingCount) {
        this.sharingCount = sharingCount;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public Integer getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    public Long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public Long getAverageViewTime() {
        if(Objects.isNull(pv) || pv.equals(0)){
            return 0L;
        }
        return totalDuration / pv;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
