package com.example.zyf.coursetablei;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.example.zyf.coursetablei.MainActivity;
/**
 * Created by ZYF on 2015/10/22.
 */
public class CircleDrop extends View {

    private Bitmap bitmap;
    private DisplayMetrics displayMetrics;
    private MainActivity mainActivity;
    Context m_context;
    public CircleDrop(Context context) {
        super(context);
        m_context=context;
    }
    public CircleDrop(Context context, AttributeSet attrs){
            super(context,attrs);
        m_context=context;
    }

    public CircleDrop(Context context,AttributeSet attrs,int defStyle){
             super(context, attrs, defStyle);
        m_context=context;
        }

    @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint=new Paint();
		    paint.setAntiAlias(true);//抗锯齿功能
		    paint.setColor(Color.RED);  //设置画笔颜色
		    //paint.setStyle(Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
		    paint.setStrokeWidth(5);//设置画笔宽度
            paint.setAlpha(255);
//		paint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影,目前不支持，不知道啊为啥

            //设置画布背景颜色

      // canvas.drawRGB(135, 206,250);
       //     canvas.drawColor(getResources().getColor(R.color.transparent));
           bitmap=BitmapFactory.decodeResource(this.getResources(),R.drawable.treeview);
           displayMetrics=new DisplayMetrics();
            displayMetrics = getResources().getDisplayMetrics();//获取屏幕信息
            int  width=displayMetrics.widthPixels;//获得宽和高
            int height=displayMetrics.heightPixels;

//取得手机屏幕大小
            //矩形路径，将图片绘制那么的大小
            RectF rectF = new RectF(0, 0, width, height);
            canvas.drawBitmap(bitmap, null,rectF, null);


        //    String string=mainActivity.getData("201315423-0");
            //第一个圆形
            Path circlePath1=new Path();
		    circlePath1.addCircle(220,200, 90, Path.Direction.CCW);//逆向绘制,还记得吗,上篇讲过的
		    canvas.drawPath(circlePath1, paint);//绘制出路径原形
            canvas.drawText("welcome my world",10,100,paint);
            //canvas.drawTextOnPath();

            //第二个圆形
            Path circlePath2=new Path();
            circlePath2.addCircle(420,200, 90, Path.Direction.CCW);//逆向绘制,还记得吗,上篇讲过的
            canvas.drawPath(circlePath2, paint);
            }




}
