package com.uitest.administrator.shoulderby.DBConnect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * sqlite数据库
 * Created by Administrator on 2017/12/12 0012.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, int version) {
        super(context, "ShouderBy.db", null, version);
    }

    /**
     * 什么时候调用：
     *  当数据库文件创建的时候调用（一次）
     *  在此方法中做什么：
     *      建表
     *      插入一些初始化数据
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
            //工作表
        String sql1 = "create table jobItem(_id integer primary key autoincrement,pic BLOB,title varchar,content varchar,money varchar)";
            //聊天联系人表
        //String sql2 = "create table chatItem(_id integer primary key autoincrement,name varchar,)";
            //聊天界面信息存储表
       // String sql3 = "create table chatMsg(_id integer primary key autoincrement,name varchar,)";
        db.execSQL(sql1);
        //创建初始化数据
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','肯德基招收前台服务员','长期兼职','120元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','安华桥顺丰快递协助员','长期兼职','160元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','石景山苹果园顺丰快递协助员','长期兼职','180元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','普通话语音采集','长期兼职','150元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','厦门好朋友餐饮招寒假工','长期兼职','80元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','地图数据拍照员','长期兼职','200元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','图片审核员周结','长期兼职','150元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','苏宁物流分拣员','长期兼职','140元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','厦门好朋友餐饮招寒假工','长期兼职','120元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','网络直播平台招主播兼职','长期兼职','120元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','招游戏代理电玩玩家','长期兼职','120元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','饿了么送餐员兼职','长期兼职','170元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','无人零食货架补货员','长期兼职','200元/天')");
        db.execSQL("insert into jobItem (pic , title , content, money) values('null','天猫内部优惠券发布员','长期兼职','150元/天')");

    }
//当传入的数据库版本号大于数据库的版本号时调用。用于版本的升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
