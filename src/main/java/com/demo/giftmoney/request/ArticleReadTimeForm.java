package com.demo.giftmoney.request;

import org.springframework.beans.factory.annotation.Autowired;

public class ArticleReadTimeForm {
    private Integer id;

    private Long duration;

    @Autowired
    public ArticleReadTimeForm() {
    }

    public ArticleReadTimeForm(Integer id, Long duration) {
        this.id = id;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
