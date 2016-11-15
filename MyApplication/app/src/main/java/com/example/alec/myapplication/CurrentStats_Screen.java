package com.example.alec.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class CurrentStats_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_stats__screen);
        final TextView aqLevel = (TextView)findViewById(R.id.AirQualityLevel_Title);
        for(int i = 0; i<10; i++)
        {
            Random rand = new Random();
            try
            {
                wait(3000);
            }
            catch (Exception e)
            {

            }
            int val = rand.nextInt();
            aqLevel.setText(val+"");
        }
    }
}
