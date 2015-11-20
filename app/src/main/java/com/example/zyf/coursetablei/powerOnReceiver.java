package com.example.zyf.coursetablei;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ZYF on 2015/11/9.
 * 创建Brodecast接收系统服务
 * 当设备开启的时候接收开机信息
 * 并启动service
 */
public class powerOnReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context,Intent intent){
        Intent serviceIntent = new Intent(context,MyService.class);
        context.startService(serviceIntent);
    }
}
