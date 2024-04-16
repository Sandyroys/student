package com.example.snackapp.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import  com.example.snackapp.model.*;
import java.util.ArrayList;
import java.util.List;
//地址管理的相关方法
public class AddressDao {
        static DbContect contect;
        static SQLiteDatabase db;
        public AddressDao(Context context) {
            contect = new DbContect(context);
        }

        //添加收货地址
    public void add(Address address) {
        db = contect.getWritableDatabase();
        db.execSQL("insert into address(username,cosignee,phone,address) values(?,?,?,?)",
                new Object[]{
                        address.getUsername(),
                        address.getCosignee(),
                        address.getPhone(),
                        address.getAddress()
                });
    }



        // 查询收货信息
        @SuppressLint("Range")
        public static Address find(int id) {
            db = contect.getWritableDatabase();
            Cursor cursor = db.rawQuery("select id,username,cosignee,phone,address from address where id=?",
                    new String[]{
                            String.valueOf(id)
                    });
//        返回结果
            if (cursor.moveToNext()) {
                return new Address(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("username")),
                        cursor.getString(cursor.getColumnIndex("cosignee")),
                        cursor.getString(cursor.getColumnIndex("phone")),
                        cursor.getString(cursor.getColumnIndex("address"))
                );
            }
            // 无结果返回
            return null;
        }
        // 删除信息
        public static void deleteId(int id) {
            db = contect.getWritableDatabase();
            db.execSQL("delete from address where id=?", new Object[]{id});
        }
        // 获取分页信息
        @SuppressLint("Range")
        public List<Address> getScrollData(int start, int count) {
            List<Address> address = new ArrayList<>();
            db = contect.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from address limit ?,?",
                    new String[]{String.valueOf(start), String.valueOf(count)});
            while (cursor.moveToNext()) {
                address.add(new Address(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("username")),
                        cursor.getString(cursor.getColumnIndex("cosignee")),
                        cursor.getString(cursor.getColumnIndex("phone")),
                        cursor.getString(cursor.getColumnIndex("address"))
                ));
            }
            return address;
        }
        // 获取总记录
        public static long getCount(){
            db = contect.getWritableDatabase();
            Cursor cursor = db.rawQuery("select max(id) from address",null);
            if(cursor.moveToNext()){

                return cursor.getLong(0);
            }
            return 0;
        }
        // 获取收入最大编号
        public static int getMaxId()
        {
            db =  contect.getWritableDatabase();
            Cursor cursor = db.rawQuery("select max(id) from address",null);
            while(cursor.moveToNext()){
                return cursor.getInt(0);
            }
            return 0;
        }
}


//    DatabaseHelper contect;
//    SQLiteDatabase db;
//    public AddressDao(Context context) {
//        contect = new DatabaseHelper();
//    private static DatabaseHelper dbHelper = new DatabaseHelper(Utils.getContext(), 1);
//
//    static {
//        dbHelper.getWritableDatabase();
//    }

    /**
     * 通过用户名查询地址信息
     */
//    public static List<Address> findAllByUsername(String username) {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        List<Address> address = new ArrayList<>();
//
//        // 查询指定用户名订单
//        Cursor cursor = db.query("address", null, "username=?", new String[]{username}, null, null, "time desc");
//        if (cursor.moveToFirst()) {
//            do {
//                String name = cursor.getString(cursor.getColumnIndex("name"));
//                Number phone = cursor.getString(cursor.getColumnIndex("phone"));
//                String address1 = cursor.getString(cursor.getColumnIndex("address"));
//
//
//                address address = new Order(name,phone,address1);
//                address.add(address);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return Address;
//    }

