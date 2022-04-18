package com.android.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int level;
    ImageView batteryImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level = 3;
        batteryImageView = findViewById(R.id.batteryImageView);
        batteryImageView.setImageLevel(level);
    }

    public void addBatteryLevel(View view) {
        if (level < 6){
            level++;
            batteryImageView.setImageLevel(level);
        }
    }

    public void subtractBatteryLevel(View view) {
        if (level > 0){
            level--;
            batteryImageView.setImageLevel(level);
        }
    }
}