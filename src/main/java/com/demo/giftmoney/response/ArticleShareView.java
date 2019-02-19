package com.demo.giftmoney.response;

public class ArticleShareView {
    private Integer articleId;

    private Integer articleRecordId;

    public ArticleShareView(Integer articleId, Integer articleRecordId) {
        this.articleId = articleId;
        this.articleRecordId = articleRecordId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleRecordId() {
        return articleRecordId;
    }

    public void setArticleRecordId(Integer articleRecordId) {
        this.articleRecordId = articleRecordId;
    }
}
