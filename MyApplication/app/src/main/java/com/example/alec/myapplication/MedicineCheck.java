package com.example.alec.myapplication;

import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.app.Notification.Builder.*;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import java.lang.Object.*;
import android.os.Bundle;
import android.view.View;

public class MedicineCheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_check);
    }


    Intent mResultIntent = new Intent(this, MedicineCheck.class);
    PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, mResultIntent, 0);
    int icon = R.mipmap.ic_launcher;
    int mId = 1;

//    Notification.Builder mBuilder = new Notification.Builder(this)
//            .setSmallIcon(icon)
//            .setContentTitle("Medicine Reminder")
//            .setContentText("You have not taken your medicine yet today")
//            .setContentIntent(mPendingIntent);

    NotificationManagerCompat nm = NotificationManagerCompat.from(getApplicationContext());

    NotificationCompat notification = new NotificationCompat.Builder(this)
            .setContentTitle("Medicine Reminder")
            .setContentText("You have not taken your medicine yet today")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(mPendingIntent)
            .build();

    nm.notify(null, 0, notification);

    /*= (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)
            .notify(mId, mBuilder.build());*/
    //nm.notify(mId, mBuilder.build());   //notify user


    /*NotificationCompat.Builder mBuilder;
    mBuilder.setSmallIcon();
    mBuilder.setContentTitle("Medicine Reminder");
    mBuilder.setContentText("You have not taken your medicine yet today.");
    mBuilder.setOngoing(true);
    Notification mNotification = mBuilder.build();*/


    /*NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("My notification")
                    .setContentText("Hello World!");
    // Creates an explicit intent for an Activity in your app
    Intent resultIntent = new Intent(this, MedicineCheck.class);
    // The stack builder object will contain an artificial back stack for the
    // started Activity.
    // This ensures that navigating backward from the Activity leads out of
    // your application to the Home screen.
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
    // Adds the back stack for the Intent (but not the Intent itself)
    stackBuilder.addParentStack(MedicineCheck.class);
    // Adds the Intent that starts the Activity to the top of the stack
    stackBuilder.addNextIntent(resultIntent);
    PendingIntent resultPendingIntent =
            stackBuilder.getPendingIntent(
                    0,
                    PendingIntent.FLAG_UPDATE_CURRENT
            );
    mBuilder.setContentIntent(resultPendingIntent);
    NotificationManager mNotificationManager =
            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    // mId allows you to update the notification later on.
    mNotificationManager.notify(mId, mBuilder.build());*/
}