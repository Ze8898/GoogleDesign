package com.six.googledesign;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        final Notification.Builder builder = new Notification.Builder(this);

        Intent intent =new Intent(Intent.ACTION_VIEW
                , Uri.parse("https://www.baidu.com/"));
        //构造PendingIntent

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentTitle("Basic notification");
        builder.setContentText("I am a Basic notification");
        builder.setSubText("it is really basic");

        //通过NotificationManager 来发出Notification

        //BASIC
        Button button = (Button) findViewById(R.id.basic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(
                        NOTIFICATION_SERVICE);
                notificationManager.notify(666,builder.build());
            }
        });

/*        //COLLAPSED
        RemoteViews contentView = new RemoteViews(getPackageName(),R.layout.notification);
        contentView.setTextViewText(R.id.text_view,"show me when collapsed");
        final Notification notification = builder.build();
        //指定视图
        notification.contentView=contentView;
        //通过RemoteViews来创建自定义的Notification试图
        RemoteViews expandedView = new RemoteViews(getPackageName(),R.layout.activity_main);
        //指定视图
        notification.bigContentView=expandedView;

        //COLLAPSED
        Button collapsed = (Button) findViewById(R.id.collapsed);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(
                        NOTIFICATION_SERVICE);
                notificationManager.notify(666,notification);
            }
        });*/
    }
}
