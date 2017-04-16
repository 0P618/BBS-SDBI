package com.goldenratio.bbs.domain;


public class PostBean {
    private String content;
    private String title;
    private String imgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public PostBean(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
