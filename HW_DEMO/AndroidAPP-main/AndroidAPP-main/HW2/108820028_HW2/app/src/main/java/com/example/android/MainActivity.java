package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button zeroButton;
    private Button countButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        zeroButton = (Button) findViewById(R.id.button_zero);
        countButton = (Button) findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void clearToZero(View view) {
        mCount = 0;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        view.setBackgroundColor(getResources().getColor(R.color.gray));
        countButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if (mCount % 2 == 0){
            view.setBackgroundColor(getResources().getColor(R.color.orange));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.green));
        }
        zeroButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
    }
}