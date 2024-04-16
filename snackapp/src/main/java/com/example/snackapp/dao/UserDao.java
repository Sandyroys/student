package com.example.snackapp.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.snackapp.model.User;
import com.example.snackapp.utils.Utils;
import com.google.gson.Gson;
//用户的相关方法
public class UserDao {
    // 实例化SharedPreferences对象
    public static SharedPreferences data = Utils.getContext().getSharedPreferences("data.json", Context.MODE_PRIVATE);


    // Gson对象  数据存储
    private static Gson gson = new Gson();

    public static boolean ifLogin() {
        try{
            return data.getBoolean("isLogin", false);
        }catch (Exception e ){
            return false;
        }

    }

    public static void ifLogin(boolean bool) {
        SharedPreferences.Editor edit = data.edit();
        edit.putBoolean("isLogin", bool);
        edit.apply();
    }
// 获取已登录用户对象
    public static User getUser() {
        String userJson = data.getString("user", "");
        return gson.fromJson(userJson, User.class);
    }

    public static void saveUser(User user) {
        String userJson = gson.toJson(user);
        SharedPreferences.Editor edit = data.edit();
        edit.putString("user", userJson);
        edit.apply();
    }
     //* 清除登录用户信息和登录状态
    public static void removeUserAndLoginStatus() {
        SharedPreferences.Editor edit = data.edit();
        edit.remove("user");
        edit.remove("isLogin");
        edit.apply();
    }

    public static void removeAll() {
        SharedPreferences.Editor edit = data.edit();
        edit.clear();
        edit.apply();
    }
    // * 保存账号
    public static void saveUsername(String username) {
        SharedPreferences.Editor editor = data.edit();
        editor.putString("username", username);
        editor.apply();
    }

    public UserDao() {
    }

    public static String getUsername() {
        return data.getString("username", "");
    }
}
