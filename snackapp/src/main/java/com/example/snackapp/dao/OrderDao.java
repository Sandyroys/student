package com.example.snackapp.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.snackapp.model.Order;
import com.example.snackapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;
//订单的相关方法
public class OrderDao {

    private static DbContect dbContect= new DbContect(Utils.getContext());
    static SQLiteDatabase db;
    static {
        dbContect.getWritableDatabase();
    }
        public OrderDao(Context context) {
            DbContect contect = new DbContect(context);

        }
    //  * 保存订单数据
    public static void saveOrder(List<Order> orders) {
        SQLiteDatabase db = dbContect.getWritableDatabase();
        for (Order order : orders) {
            ContentValues values = new ContentValues();
            values.put("name", order.getName());
            values.put("image", order.getImage());
            values.put("money", order.getMoney());
            values.put("time", order.getTime());
            values.put("username", order.getUsername());

            db.insert("orders", null, values);
        }
    }



    // * 通过用户名查询订单数据
    public static List<Order> findAllByUsername(String username) {
        SQLiteDatabase db = dbContect.getWritableDatabase();
        List<Order> orders = new ArrayList<>();
        // 查询指定用户名订单
        Cursor cursor = db.query("orders", null, "username=?", new String[]{username}, null, null, "time desc");
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") int image = cursor.getInt(cursor.getColumnIndex("image"));
                @SuppressLint("Range") double money = cursor.getDouble(cursor.getColumnIndex("money"));
                @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex("time"));

                Order order = new Order(name, image, money, time);
                orders.add(order);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orders;
    }

  //   * 通过商品名称查询订单
    public static List<Order> findAllByName(String names) {
        SQLiteDatabase db = dbContect.getWritableDatabase();
        List<Order> orders1 = new ArrayList<>();

        // 查询指定用户名订单
        Cursor cursor = db.query("orders", null, "name=?", new String[]{names}, null, null, "time desc");
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") int image = cursor.getInt(cursor.getColumnIndex("image"));
                @SuppressLint("Range") double money = cursor.getDouble(cursor.getColumnIndex("money"));
                @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex("time"));

                Order order = new Order(name, image, money, time);
                orders1.add(order);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orders1;
    }
    // 获取分页信息
    @SuppressLint("Range")
    public List<Order> getScrollData(int start, int count) {
        List<Order> orders = new ArrayList<>();
        db = dbContect.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from orders limit ?,?",
                new String[]{String.valueOf(start), String.valueOf(count)});
        while (cursor.moveToNext()) {
           orders.add(new Order(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("image")),
                    cursor.getString(cursor.getColumnIndex("money")),
                    cursor.getString(cursor.getColumnIndex("time")),
                    cursor.getString(cursor.getColumnIndex("username"))
            ));
        }
        return orders;
    }
    // 获取总记录
    public static long getCount(){
        db = dbContect.getWritableDatabase();
        Cursor cursor = db.rawQuery("select max(id) from orders",null);
        if(cursor.moveToNext()){

            return cursor.getLong(0);
        }
        return 0;
    }
   /* public static void deleteId(int id) {
        db = contect.getWritableDatabase();
        db.execSQL("delete from address where id=?", new Object[]{id});
    }*/
    //删除订单信息
    public static void deleteOrder(String username , String name){
        SQLiteDatabase db = dbContect.getWritableDatabase();
        db.execSQL("delete from orders where username = ? and name =?");
    }
}
