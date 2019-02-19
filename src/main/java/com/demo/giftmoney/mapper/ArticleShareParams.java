package com.demo.giftmoney.mapper;

public class ArticleShareParams {
    private Integer id;

    private Integer path;

    public ArticleShareParams(Integer id, Integer path) {
        this.id = id;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPath() {
        return path;
    }

    public void setPath(Integer path) {
        this.path = path;
    }
}
