package com.demo.giftmoney.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerLoginForm {

    @NotEmpty
    private String code;

    private Integer customerId;

    private Integer articleId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}