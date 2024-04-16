package com.example.snackapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class RandomService extends Service {



        private String TAG = this.getClass().getSimpleName();
        private Thread randomThread;

        public RandomService() {
        }

        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }


        @Override
        public void onCreate() {
            super.onCreate();
            Toast.makeText(this, TAG + "has already executed onCreate method",
                    Toast.LENGTH_SHORT).show();
            //service被创建之后就实例化一个子线程
           // randomThread = new Thread(runnable);//实例化一个子线程
            //runnable作为参数
        }




        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            Toast.makeText(this, TAG + "has already executed onStartCommand method",
                    Toast.LENGTH_SHORT).show();
            //service启动时让子线程启动
            if (!randomThread.isAlive()) {
                randomThread.start();//如果子线程没有启动则启动它并在log中做上记录
                Log.d(TAG, "the ThreadId is " + randomThread.getId() + "in onStartCommand");
            }
            return super.onStartCommand(intent, flags, startId);
        }

        @Override
        public void onDestroy() {
            Toast.makeText(this, TAG + "has already executed onDestory method",
                    Toast.LENGTH_SHORT).show();
            super.onDestroy();
            randomThread.interrupt();
            //service结束被销毁之后阻塞子线程
        }


}