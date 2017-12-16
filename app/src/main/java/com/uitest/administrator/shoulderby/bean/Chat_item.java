package com.uitest.administrator.shoulderby.bean;

/**
 * Created by Administrator on 2017/12/9 0009.
 */

public class Chat_item {
    private int head;               //头像
    private String username;        //用户名
    private String content;         //内容

    public Chat_item(int head, String username, String content) {
        this.head = head;
        this.username = username;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Chat_item{" +
                "head=" + head +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
