package com.demo.giftmoney.request;

import com.sug.core.platform.web.pagination.PaginationForm;

import javax.validation.constraints.NotNull;

public class GiftMoneyListForm extends PaginationForm{

    private String content;

    @NotNull
    private Integer type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
