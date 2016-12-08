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

        boolean notTaken = true;
        if(notTaken) {
            pushNotify();
        }
    }

    private void pushNotify() {

        Intent mResultIntent = new Intent(this, MedicineCheck.class);
        PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, mResultIntent, 0);
        int icon = R.drawable.ic_stat_pill;
        int mId = 58392;

        Notification.Builder mBuilder = new Notification.Builder(this)
                .setSmallIcon(icon)
                .setContentTitle("Medicine Reminder")
                .setContentText("You have not taken your medicine yet today")
                .setContentIntent(mPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager)getSystemService
                (Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId, mBuilder.build());

    }
}