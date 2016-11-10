package com.example.alec.myapplication;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.NotificationManager;
import android.app.Notification;
@TargetApi(24)
public class AsthmaTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long myID = updateDB();
                Snackbar.make(view, myID+"", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    protected long updateDB()
    {
        AsthmaTestDB mDbHelper = new AsthmaTestDB(this);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("Name", "Jim");

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert("AsthmaStuff", null, values);

        return newRowId;
    }
    /*android.support.v4.app.NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(this)
                    .setContentTitle("take your asthma inhaler")
                    .setContentText("stupid???");
    // Creates an explicit intent for an Activity in your app
    Intent resultIntent = new Intent(this, AsthmaTest.class);

    // The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
    stackBuilder.addParentStack(AsthmaTest.class);
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
