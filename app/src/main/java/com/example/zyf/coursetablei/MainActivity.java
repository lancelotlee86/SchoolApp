package com.example.zyf.coursetablei;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Method;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("课程表");
        btnclick();
        //假设从服务器取得数据，格式如下：课程、周数、星期几、第几节、教室号

        SetTableText(1);



        //新建activity时自带的工具和一些功能
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "校训：勤奋，严谨，求实，创新", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
     public void startSecond(View view){
         Intent intent = new Intent(this, TreeListActivity.class);
         startActivity(intent);
     }
    @Override
    public void finish(){
        /**
         * 重载finish，按两次返回键退出程序
         */

        if(count==2)
        {
            super.finish();
        }
        else{
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_LONG).show();
            count++;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,settingsActivity.class);
            startActivity(intent);
        }
        if(id==R.id.action_exit){
           super.finish();
        }
        if(id==R.id.action_canceled){
            Intent intent=new Intent(this,loginActivity.class);
            startActivity(intent);
        }
        if(id==R.id.action_near){

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        /*
        *overflow中的Action按钮应不应该显示图标，
        * 是由MenuBuilder这个类的setOptionalIconsVisible变量来决定的，
        * 如果我们在overflow被展开的时候将这个变量赋值为true，
        * 那么里面的每一个Action按钮对应的图标就都会显示出来了。
        * 赋值的方法当然仍然是用反射了.
        */
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, false);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
    /*
    *获取存取的数据，dataName为数据名，非数据内容
     */
    public String getData(String dataName){
        SharedPreferences gettings = getSharedPreferences("string", 0);
        String silent = gettings.getString(dataName, "string");
        //TextView Ta11=(TextView)findViewById(R.id.a51);
      //  Ta51.setText(silent);
       return silent;

    }
    /*
    *储存数据的函数
    * string为数据内容，dataName为数据名
    * 函数内容为存储数据的方法
    */
    public void Savedata(String string,String dataName){
        SharedPreferences settings = getSharedPreferences("string", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(dataName, string);

        // Commit the edits!
        editor.commit();
    }
    /*
    *待定
     */
    public void SetTableText(int weekth){
        /*
        * 将存储的课程信息读取出来并进行显示
        * */
        //获取屏幕个区域id
        TextView Ta21=(TextView)findViewById(R.id.a21);
        TextView Ta22=(TextView)findViewById(R.id.a22);
        TextView Ta23=(TextView)findViewById(R.id.a23);
        TextView Ta24=(TextView)findViewById(R.id.a24);
        TextView Ta25=(TextView)findViewById(R.id.a25);
        TextView Ta31=(TextView)findViewById(R.id.a31);
        TextView Ta32=(TextView)findViewById(R.id.a32);
        TextView Ta33=(TextView)findViewById(R.id.a33);
        TextView Ta34=(TextView)findViewById(R.id.a34);
        TextView Ta35=(TextView)findViewById(R.id.a35);
        TextView Ta41=(TextView)findViewById(R.id.a41);
        TextView Ta42=(TextView)findViewById(R.id.a42);
        TextView Ta43=(TextView)findViewById(R.id.a43);
        TextView Ta44=(TextView)findViewById(R.id.a44);
        TextView Ta45=(TextView)findViewById(R.id.a45);
        TextView Ta51=(TextView)findViewById(R.id.a51);
        TextView Ta52=(TextView)findViewById(R.id.a52);
        TextView Ta53=(TextView)findViewById(R.id.a53);
        TextView Ta54=(TextView)findViewById(R.id.a54);
        TextView Ta55=(TextView)findViewById(R.id.a55);
        TextView Ta61=(TextView)findViewById(R.id.a61);
        TextView Ta62=(TextView)findViewById(R.id.a62);
        TextView Ta63=(TextView)findViewById(R.id.a63);
        TextView Ta64=(TextView)findViewById(R.id.a64);
        TextView Ta65=(TextView)findViewById(R.id.a65);



        clearText();
        String datanum=getData("201315423tableNum");
        int Sdatanum=Integer.parseInt(datanum);
        int i;
        for( i=0;i<Sdatanum;i++)
        {
            Calendar calendar=Calendar.getInstance();
            int weekday=calendar.get(Calendar.DAY_OF_WEEK);
            String[] splitdata=(getData("201315423"+"-"+i)).split(",");
            String tableText=splitdata[0] + splitdata[5];
            int splitdata1=Integer.parseInt(splitdata[1]);
            int splitdata2=Integer.parseInt(splitdata[2]);
            int splitdata3=Integer.parseInt(splitdata[3]);
            int splitdata4=Integer.parseInt(splitdata[4]);
            if(weekth>=splitdata1 && weekth<=splitdata2){
                switch (splitdata3) {
                    case 1: {
                        if (splitdata4 == 1) {
                            Ta21.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 2) {
                            Ta31.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 3) {
                            Ta41.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 4) {
                            Ta51.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 5) {
                            Ta61.setText(tableText);
                            continue;
                        }
                    }
                    case 2: {
                        if (splitdata4 == 1) {
                            Ta22.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 2) {
                            Ta32.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 3) {
                            Ta42.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 4) {
                            Ta52.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 5) {
                            Ta62.setText(tableText);
                            continue;
                        }
                    }
                    case 3: {
                        if (splitdata4 == 1) {
                            Ta23.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 2) {
                            Ta33.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 3) {
                            Ta43.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 4) {
                            Ta53.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 5) {
                            Ta63.setText(tableText);
                            continue;
                        }
                    }

                    case 4: {
                        if (splitdata4 == 1) {
                            Ta24.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 2) {
                            Ta34.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 3) {
                            Ta44.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 4) {
                            Ta54.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 5) {
                            Ta64.setText(tableText);
                            continue;
                        }
                    }
                    case 5: {
                        if (splitdata4 == 1) {
                            Ta25.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 2) {
                            Ta35.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 3) {
                            Ta45.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 4) {
                            Ta55.setText(tableText);
                            continue;
                        }
                        if (splitdata4 == 5) {
                            Ta65.setText(tableText);
                            continue;
                        }
                    }
                }

            }


        }
    }
    public void setdaytime(){
        Calendar calendar=Calendar.getInstance();
       int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int weekday=calendar.get(Calendar.DAY_OF_WEEK);
    }
    public void clearText(){
        TextView Ta21=(TextView)findViewById(R.id.a21);
        TextView Ta22=(TextView)findViewById(R.id.a22);
        TextView Ta23=(TextView)findViewById(R.id.a23);
        TextView Ta24=(TextView)findViewById(R.id.a24);
        TextView Ta25=(TextView)findViewById(R.id.a25);
        TextView Ta31=(TextView)findViewById(R.id.a31);
        TextView Ta32=(TextView)findViewById(R.id.a32);
        TextView Ta33=(TextView)findViewById(R.id.a33);
        TextView Ta34=(TextView)findViewById(R.id.a34);
        TextView Ta35=(TextView)findViewById(R.id.a35);
        TextView Ta41=(TextView)findViewById(R.id.a41);
        TextView Ta42=(TextView)findViewById(R.id.a42);
        TextView Ta43=(TextView)findViewById(R.id.a43);
        TextView Ta44=(TextView)findViewById(R.id.a44);
        TextView Ta45=(TextView)findViewById(R.id.a45);
        TextView Ta51=(TextView)findViewById(R.id.a51);
        TextView Ta52=(TextView)findViewById(R.id.a52);
        TextView Ta53=(TextView)findViewById(R.id.a53);
        TextView Ta54=(TextView)findViewById(R.id.a54);
        TextView Ta55=(TextView)findViewById(R.id.a55);
        TextView Ta61=(TextView)findViewById(R.id.a61);
        TextView Ta62=(TextView)findViewById(R.id.a62);
        TextView Ta63=(TextView)findViewById(R.id.a63);
        TextView Ta64=(TextView)findViewById(R.id.a64);
        TextView Ta65=(TextView)findViewById(R.id.a65);
        Ta21.setText("");
        Ta22.setText("");
        Ta23.setText("");
        Ta24.setText("");
        Ta25.setText("");
        Ta31.setText("");
        Ta32.setText("");
        Ta33.setText("");
        Ta34.setText("");
        Ta35.setText("");
        Ta41.setText("");
        Ta42.setText("");
        Ta43.setText("");
        Ta44.setText("");
        Ta45.setText("");
        Ta51.setText("");
        Ta52.setText("");
        Ta53.setText("");
        Ta54.setText("");
        Ta55.setText("");
        Ta61.setText("");
        Ta62.setText("");
        Ta63.setText("");
        Ta64.setText("");
        Ta65.setText("");
    }
    public void btnclick(){
        /*
        *按钮监听函数
         */
       final Button btn=(Button)findViewById(R.id.btn);
        final Button btn1=(Button)findViewById(R.id.btn1);
        final Button btn2=(Button)findViewById(R.id.btn2);
        final Button btn3=(Button)findViewById(R.id.btn3);
        final Button btn4=(Button)findViewById(R.id.btn4);
        final  Button btn5=(Button)findViewById(R.id.btn5);
        final Button btn6=(Button)findViewById(R.id.btn6);
        final Button btn7=(Button)findViewById(R.id.btn7);
        final Button btn8=(Button)findViewById(R.id.btn8);
        final Button btn9=(Button)findViewById(R.id.btn9);
        final Button btn10=(Button)findViewById(R.id.btn10);
        final  Button btn11=(Button)findViewById(R.id.btn11);
        final Button btn12=(Button)findViewById(R.id.btn12);
        final  Button btn13=(Button)findViewById(R.id.btn13);
        final  Button btn14=(Button)findViewById(R.id.btn14);
        final  Button btn15=(Button)findViewById(R.id.btn15);
        final  Button btn16=(Button)findViewById(R.id.btn16);
        final  Button btn17=(Button)findViewById(R.id.btn17);
        final  Button btn18=(Button)findViewById(R.id.btn18);
        final  Button btn19=(Button)findViewById(R.id.btn19);
        final Button btn20=(Button)findViewById(R.id.btn20);
        final  Button btn21=(Button)findViewById(R.id.btn21);
        final  Button btn22=(Button)findViewById(R.id.btn22);
        final LinearLayout TableView=(LinearLayout)findViewById(R.id.TableView);

        final ScrollView Lview=(ScrollView)findViewById(R.id.hidden);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Lview.getVisibility() == View.VISIBLE)
                    Lview.setVisibility(View.GONE);
                else
                    Lview.setVisibility(View.VISIBLE);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("1");
                Savedata("1", "btnText");
                SetTableText(1);
                v.setFocusableInTouchMode(true);
                Lview.setVisibility(View.GONE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("2");

                Savedata("2", "btnText");
                SetTableText(2);
                v.setFocusableInTouchMode(true);
                Lview.setVisibility(View.GONE);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("3");

                Savedata("3", "btnText");
                SetTableText(3);
                v.setFocusableInTouchMode(true);
                Lview.setVisibility(View.GONE);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("4");
                Lview.setVisibility(View.GONE);
                Savedata("4", "btnText");
                SetTableText(4);
                v.setFocusableInTouchMode(true);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("5");
                Lview.setVisibility(View.GONE);
                Savedata("5", "btnText");
                SetTableText(5);
                v.setFocusableInTouchMode(true);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("6");
                Lview.setVisibility(View.GONE);
                Savedata("6", "btnText");
                SetTableText(6);
                v.setFocusableInTouchMode(true);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("7");
                Lview.setVisibility(View.GONE);
                Savedata("7", "btnText");
                SetTableText(7);
                v.setFocusableInTouchMode(true);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("8");
                Lview.setVisibility(View.GONE);
                Savedata("8", "btnText");
                SetTableText(8);
                v.setFocusableInTouchMode(true);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("9");
                Lview.setVisibility(View.GONE);
                Savedata("9", "btnText");
                SetTableText(9);
                v.setFocusableInTouchMode(true);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("10");
                Lview.setVisibility(View.GONE);
                Savedata("10", "btnText");
                SetTableText(10);
                v.setFocusableInTouchMode(true);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("11");
                Lview.setVisibility(View.GONE);
                Savedata("11", "btnText");
                SetTableText(11);
                v.setFocusableInTouchMode(true);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("12");
                Lview.setVisibility(View.GONE);
                Savedata("12", "btnText");
                SetTableText(12);
                v.setFocusableInTouchMode(true);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("13");
                Lview.setVisibility(View.GONE);
                Savedata("13", "btnText");
                SetTableText(13);
                v.setFocusableInTouchMode(true);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("14");
                Lview.setVisibility(View.GONE);
                Savedata("14", "btnText");
                SetTableText(14);
                v.setFocusableInTouchMode(true);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("15");
                Lview.setVisibility(View.GONE);
                Savedata("15", "btnText");
                SetTableText(15);
                v.setFocusableInTouchMode(true);
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("16");
                Lview.setVisibility(View.GONE);
                Savedata("16", "btnText");
                SetTableText(16);
                v.setFocusableInTouchMode(true);
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("17");
                Lview.setVisibility(View.GONE);
                Savedata("17", "btnText");
                SetTableText(17);
                v.setFocusableInTouchMode(true);
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("18");
                Lview.setVisibility(View.GONE);
                Savedata("18", "btnText");
                SetTableText(18);
                v.setFocusableInTouchMode(true);
            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("19");
                Lview.setVisibility(View.GONE);
                Savedata("19", "btnText");
                SetTableText(19);
                v.setFocusableInTouchMode(true);
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("20");
                Lview.setVisibility(View.GONE);
                Savedata("20", "btnText");
                SetTableText(20);
                v.setFocusableInTouchMode(true);
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("21");
                Lview.setVisibility(View.GONE);
                Savedata("21", "btnText");
                SetTableText(21);
                v.setFocusableInTouchMode(true);
              //  v.setBackgroundResource(R.color.red);
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("22");
                Lview.setVisibility(View.GONE);
                Savedata("22", "btnText");
                SetTableText(22);
                //  v.setBackgroundResource(R.color.red);
                //获得上次选择按钮之后的焦点
                v.setFocusableInTouchMode(true);

                // btn22.setFocusable(true);
                //btn22.setFocusableInTouchMode(true);
                // btn.requestFocus();
                // btn.requestFocusFromTouch();

            }
        });
        btn1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    btn1.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setFocusableInTouchMode(false);
                    v.setBackgroundResource(R.drawable.text_view_border7);
                }
            }
        });
        btn3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn8.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn9.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn11.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn12.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn13.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn14.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn15.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn16.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn17.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn18.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn19.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn20.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn21.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });
        btn22.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    v.setBackgroundResource(R.drawable.text_view_border8);
                else {
                    v.setBackgroundResource(R.drawable.text_view_border7);
                    v.setFocusableInTouchMode(false);
                }
            }
        });

    }
    public void initial(){
        /*
        *初始化函数,我希望能把所有启动初始化的东西放在这个函数里面
         */
        String getdata=getData("btnText");
        Button btn=(Button)findViewById(R.id.btn);
        btn.setText(getdata);
        int datanum=Integer.parseInt(getdata);
        SetTableText(datanum);
    }
}
