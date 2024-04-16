package com.example.snackapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.snackapp.dao.UserDao;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//主要框架 底部的导航栏
public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // BottomNavigationView时底部菜单栏控件
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //主布局即Activity由BottomNavigationView和fragment 构成。
        //BottomNavigationView 用于呈现底部导航栏，fragment组件 用于显示每个导航栏对应的Fragment
        // 将每个菜单ID作为一组ID传递
        // 因为每个菜单都应该被视为顶级路径
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_snack, R.id.navigation_place, R.id.navigation_my)
                .build();
        //当前页面显示的fragment

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        // 检查登录状态
        checkLogin();
    }

    //检查是否有登录信息
    private void checkLogin() {
        // 检查持久化的数据

        if (UserDao.ifLogin()) {
            // 已登录
            MyApplication.isLogin(true);
            MyApplication.setUser(UserDao.getUser());
        } else {
            // 未登录
            MyApplication.isLogin(false);
            MyApplication.setUser(null);
        }
    }

}