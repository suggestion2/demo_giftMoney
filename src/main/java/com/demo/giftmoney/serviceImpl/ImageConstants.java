package com.demo.giftmoney.serviceImpl;

/**
 * Created by Administrator on 2018/3/30.
 */
public enum ImageConstants {
    BANNER("/banner/"),
    GOODS_CATEGORY("/category/"),
    GOODS("/goods/"),
    ARTICLE("/article/"),
    CUSTOMER("/customer/");

    ImageConstants(String url) {
        this.url = url;
    }

    private String url;

    public String getUrl() {
        return url;
    }
}
