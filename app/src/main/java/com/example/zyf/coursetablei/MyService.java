package com.example.zyf.coursetablei;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/**
 * Created by ZYF on 2015/11/9.
 */
public class MyService extends Service {
    /*
    *创建后台服务
    * 用于某些定时服务
    */

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
    @Override
    public void onStart(Intent intent,int startId){
        super.onStart(intent,startId);
    }
}
