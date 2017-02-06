package com.dopool.game.model;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class GameBean {

    private String url ;
    private String text ;

    public GameBean(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
