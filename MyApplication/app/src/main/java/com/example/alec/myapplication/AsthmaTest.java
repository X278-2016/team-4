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
import android.widget.Spinner;
import android.database.sqlite.*;

import java.util.Random;

import static com.example.alec.myapplication.R.id.spinner;
import static com.example.alec.myapplication.R.id.spinner2;

@TargetApi(24)
public class AsthmaTest extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Spinner spinner1 = (Spinner)findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
        final Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val1 = spinner1.getSelectedItem().toString();
                String val2 = spinner2.getSelectedItem().toString();
                String val3 = spinner3.getSelectedItem().toString();
                String val4 = spinner4.getSelectedItem().toString();
                long myID = updateDB(val1,val2,val3,val4);
                String sText = spinner1.getSelectedItem().toString();
                Snackbar.make(view, "data stored!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    protected long updateDB(String val1, String val2, String val3, String val4)
    {
        AsthmaTestDB mDbHelper = new AsthmaTestDB(this);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        //values.put("Date", "datetime('now')");
        int time =  (int) (System.currentTimeMillis() / 1000L);
        values.put("Date", time+"");
        values.put("Name", "Jim");
        values.put("FirstNum", val1);
        values.put("SecondNum", val2);
        values.put("ThirdNum", val3);
        values.put("FourthNum", val4);

        return 0;
    }
}
