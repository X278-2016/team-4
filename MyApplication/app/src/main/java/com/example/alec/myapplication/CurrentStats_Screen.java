package com.example.alec.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Thread.sleep;

public class CurrentStats_Screen extends AppCompatActivity {

    private final String airFeed = "airnowapi.org/aq/data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_stats__screen);
        final TextView aqLevel = (TextView)findViewById(R.id.AirQualityLevel_Title);
        for(int i = 0; i<10; i++)
        {
            Random rand = new Random();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int val = rand.nextInt();
            aqLevel.setText(val+"");
        }
    }
}
