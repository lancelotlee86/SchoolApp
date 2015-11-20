package com.example.zyf.coursetablei;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;



public class SplashActivity extends Activity {
    private final int splash_display_lenght=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent=new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        },splash_display_lenght);
    }
}
