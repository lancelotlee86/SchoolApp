package com.example.zyf.coursetablei;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.example.zyf.coursetablei.Appdata;
/**
 * Created by ZYF on 2015/11/10.
 */
public class settingsActivity extends Activity {
   private Context context;
    Appdata appdata;
    MainActivity MA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        appdata=(Appdata)getApplicationContext();
        final TextView num=(TextView)findViewById(R.id.num);
       num.setText(appdata.username);
        Switch switch1=(Switch)findViewById(R.id.switch1);
       switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                   appdata.username = "true";

               } else {
                   appdata.userud = "false";

               }
           }
       });

    }
    public void canceled(View view){
        Intent intent=new Intent(this,loginActivity.class);
        startActivity(intent);
    }
    public void exited(View view){
        super.finish();
    }
    @Override
    public void finish(){
        super.finish();
    }
}
