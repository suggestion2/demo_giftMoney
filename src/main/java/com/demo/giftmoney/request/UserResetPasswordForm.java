package com.demo.giftmoney.request;

import javax.validation.constraints.NotEmpty;

public class UserResetPasswordForm {
    @NotEmpty
    private String originPassword;
    @NotEmpty
    private String newPassword;

    public String getOriginPassword() {
        return originPassword;
    }

    public void setOriginPassword(String originPassword) {
        this.originPassword = originPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
