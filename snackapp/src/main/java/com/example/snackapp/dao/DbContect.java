package com.example.snackapp.dao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//数据库连接与创建
public class DbContect extends SQLiteOpenHelper {
    private static final int VERSION=2;
    private static final String DBNAME="SnackStore.db";   //  创建数据库名叫 Users
    private Context mContext;
    public DbContect(Context context){super(context,DBNAME,null,VERSION);
        mContext = context;
    }
    //创建数据库
    public void onCreate(SQLiteDatabase db){
        // 创建orders表  订单表
        String createOrders = "create table IF NOT EXISTS orders (" +
                "id integer primary key autoincrement," +
                "name text," +
                "image integer," +
                "money real," +
                "time text," +
                "username text)";
        db.execSQL(createOrders);
        // 创建address表  地址表
        String createAddress = "create table IF NOT EXISTS address(id integer primary key autoincrement, username text, cosignee text,phone number,address text)";
        db.execSQL(createAddress);
        // 创建 user表   用户表
        String createUsers = "create table IF NOT EXISTS user(username text primary key ,password text,phone text)";
        db.execSQL(createUsers);
    }
    //数据库版本更新
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists orders");
        db.execSQL("drop table if exists address");
        onCreate(db);
    }
}
