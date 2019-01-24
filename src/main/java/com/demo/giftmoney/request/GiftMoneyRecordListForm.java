package com.demo.giftmoney.request;

import com.sug.core.platform.web.pagination.PaginationForm;

import javax.validation.constraints.NotNull;

public class GiftMoneyRecordListForm extends PaginationForm{

    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
