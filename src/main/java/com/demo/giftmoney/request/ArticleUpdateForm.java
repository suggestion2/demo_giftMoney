package com.demo.giftmoney.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ArticleUpdateForm {

    @NotNull
    private Integer id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    @NotEmpty
    private String img;
    @NotEmpty
    private String content;
    @NotNull
    private Integer giftMoneyId;

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }
    public String getTitle() {
    return title;
    }

    public void setTitle(String title) {
    this.title = title;
    }
    public String getAuthor() {
    return author;
    }

    public void setAuthor(String author) {
    this.author = author;
    }
    public String getImg() {
    return img;
    }

    public void setImg(String img) {
    this.img = img;
    }
    public String getContent() {
    return content;
    }

    public void setContent(String content) {
    this.content = content;
    }
    public Integer getGiftMoneyId() {
    return giftMoneyId;
    }

    public void setGiftMoneyId(Integer giftMoneyId) {
    this.giftMoneyId = giftMoneyId;
    }

}