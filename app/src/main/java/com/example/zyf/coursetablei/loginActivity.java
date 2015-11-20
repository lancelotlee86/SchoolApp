package com.example.zyf.coursetablei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ZYF on 2015/11/9.
 */
public class loginActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        EditText userId=(EditText)findViewById(R.id.userId);
        EditText userPs=(EditText)findViewById(R.id.userPs);

    }
    public void loginBt(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
