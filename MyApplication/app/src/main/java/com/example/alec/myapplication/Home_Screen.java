package com.example.alec.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.alec.myapplication.R.styleable.View;

public class Home_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);
        Button settings = (Button) findViewById(R.id.settings_button);
        settings.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this, Settings_Screen.class));
            }
        });
        Button help = (Button) findViewById(R.id.help_button);
        settings.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this, Help_Screen.class));
            }
        });
        Button connectMyHealthLogin = (Button) findViewById(R.id.connect_my_health_login_button);
        settings.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this, MyHealthLogin_Screen.class));
            }
        });
        Button asthmaControlTest = (Button) findViewById(R.id.asthma_control_test_button);
        settings.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this, AsthmaTest.class));
            }
        });
        Button currentStats = (Button) findViewById(R.id.current_stats_button);
        settings.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this, CurrentStats_Screen.class));
            }
        });
        Button medicineLog = (Button) findViewById(R.id.medicine_log_button);
        settings.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this, MedicineCheck.class));
            }
        });
    }
}
