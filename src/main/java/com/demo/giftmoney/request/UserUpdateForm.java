package com.demo.giftmoney.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserUpdateForm {

    @NotNull
    private Integer id;
    @NotEmpty
    private String name;
    @NotNull
    private Integer admin;

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }
    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }
    public Integer getAdmin() {
    return admin;
    }

    public void setAdmin(Integer admin) {
    this.admin = admin;
    }

}