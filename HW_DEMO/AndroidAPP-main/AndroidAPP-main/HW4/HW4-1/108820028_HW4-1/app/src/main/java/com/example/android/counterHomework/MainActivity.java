package com.example.android.counterHomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count;
    private TextView countShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        countShow = (TextView)findViewById(R.id.textView_count_show);

        if (savedInstanceState != null) {
            countShow.setText(Integer.toString(savedInstanceState.getInt("count")));
            count = savedInstanceState.getInt("count");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (countShow.getVisibility() == View.VISIBLE) {
            outState.putInt("count", count);
        }
    }

    public void onClick(View view) {
        count += 1;
        countShow.setText(Integer.toString(count));
    }
}