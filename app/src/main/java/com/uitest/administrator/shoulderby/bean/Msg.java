package com.uitest.administrator.shoulderby.bean;

/**
 * Created by jared on 16/2/10.
 */
public class Msg {
    public static final int TYPE_RECEIVED = 0;      //接受到的信息
    public static final int TYPE_SEND = 1;          //发送的信息

    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
