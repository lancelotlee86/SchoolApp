package com.example.zyf.coursetablei;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Message;
import android.widget.RemoteViews;

/**
 * Created by ZYF on 2015/11/10.
 */
public class Table_widgetActivity extends AppWidgetProvider {
    private int[] appWidgetIds;
    private AppWidgetManager appWidgetManager;
    private Context context;
    public void onUpdate(Context context,AppWidgetManager appWidgetManager,int[] appWidgetIds){
        RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.table_widget);
        views.setTextViewText(R.id.TW1,"课程一");
        views.setTextViewText(R.id.TW2,"课程二");
        views.setTextViewText(R.id.TW3,"课程三");
        views.setTextViewText(R.id.TW4,"课程四");
        views.setTextViewText(R.id.TW5,"课程五");
        appWidgetManager.updateAppWidget(appWidgetIds,views);
    }
}
