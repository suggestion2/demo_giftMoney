package com.demo.giftmoney.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserCreateForm {

    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    @NotNull
    private Integer admin;

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }
    public String getPassword() {
    return password;
    }

    public void setPassword(String password) {
    this.password = password;
    }
    public Integer getAdmin() {
    return admin;
    }

    public void setAdmin(Integer admin) {
    this.admin = admin;
    }

}