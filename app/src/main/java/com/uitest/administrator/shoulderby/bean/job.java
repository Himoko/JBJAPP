package com.uitest.administrator.shoulderby.bean;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class job {

    private int pic;            //图片
    private String title;       //标题
    private String content;     //内容
    private String money;       //工资

    public job(int pic, String title, String content, String money) {
        this.pic = pic;
        this.title = title;
        this.content = content;
        this.money = money;
    }

    @Override
    public String toString() {
        return "job{" +
                "pic=" + pic +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public int getPic() {return pic;}

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
