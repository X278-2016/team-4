package com.example.alec.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.alec.myapplication.R.styleable.View;

public class Home_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);
        Button settings = (Button) findViewById(R.id.settings_button);
    }

    public void sendToSettings(View view) {
        Intent intent = new Intent(this, Settings_Screen.class);
        startActivity(intent);
    }

    public void sendToHelp(View view) {
        Intent intent = new Intent(this, Help_Screen.class);
        startActivity(intent);
    }

    public void sendToMyhealth(View view) {
        Intent intent = new Intent(this, MyHealthLogin_Screen.class);
        startActivity(intent);
    }

    public void sendToControlTest(View view) {
        Intent intent = new Intent(this, AsthmaTest.class);
        startActivity(intent);
    }

    public void sendToMedLog(View view) {
        Intent intent = new Intent(this, MedicineCheck.class);
        startActivity(intent);
    }

    public void sendToStats(View view) {
        Intent intent = new Intent(this, CurrentStats_Screen.class);
        startActivity(intent);
    }
}
