package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class MainActivity_Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);
        //getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsActivity()).commit();
        this.setTitle(R.string.Settings);
        SettingsActivity fragmentB = new SettingsActivity();
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragmentB)
                .commit();
    }
}