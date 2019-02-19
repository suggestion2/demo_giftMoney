package com.demo.giftmoney.mapper;

import java.math.BigDecimal;

public class GiftMoneyDeductBalanceParams {
    private Integer id;

    private BigDecimal remainAmount;

    public GiftMoneyDeductBalanceParams(Integer id, BigDecimal remainAmount) {
        this.id = id;
        this.remainAmount = remainAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }
}
