package com.demo.giftmoney.request;

import com.sug.core.platform.web.pagination.PaginationForm;

public class CustomerListForm extends PaginationForm{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
