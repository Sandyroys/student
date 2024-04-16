package com.example.snackapp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
//工具
public class Utils {
    @SuppressLint("StaticFieldLeak")
    private static Context context ;

    private Utils() {

        throw new UnsupportedOperationException("我是需要实例化的啦！！！");
    }

    public static void setContext(Context context) {
        Utils.context = context;
    }

    /**
     * 初始化工具类
     * context 上下文
     */
    public static void init(Context context) {
       // Log.i("zut", "init: context");
        Utils.context = context.getApplicationContext();

    }

    /**
     * 获取应用的ApplicationContext
     * @return ApplicationContext
     */
    public static Context getContext() {

        if (context != null) {
            return context;
        }
            throw new NullPointerException("上下文为空啊！！！");

    }
}
