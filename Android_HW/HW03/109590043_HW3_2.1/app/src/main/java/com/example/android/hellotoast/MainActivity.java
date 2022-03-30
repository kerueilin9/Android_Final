/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.hellotoast;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Displays two Buttons and a TextView.
 * - Pressing the TOAST button shows a Toast.
 * - Pressing the COUNT button increases the displayed mCount.
 *
 * Note: Fixing behavior when device is rotated is a challenge exercise for the student.
 */

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";

    private int mCount = 0;
    private TextView mShowCount;
    private Button B_say, B_count;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        B_say = (Button) findViewById(R.id.button_toast);
        B_count = (Button) findViewById(R.id.button_count);
    }

    /*
    * Shows a Toast when the TOAST button is clicked.
    *
    * @param view The view that triggered this onClick handler.
    *             Since a toast always shows on the top,
    *             the passed in view is not used.
    */
    public void showToast(View view) {
//        Toast toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT);
//        toast.show();
//
//        B_say.setVisibility(View.GONE);
//        B_count.setVisibility(View.GONE);
//        mShowCount.setTextSize(50);
//        mShowCount.setTextColor(0xFF777777);
////        mShowCount.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
////        mShowCount.setTextColor(getResources().getColor(this, R.color.colorPrimary));
//        mShowCount.setBackgroundColor(Color.rgb(255,255,255));
//        mShowCount.setText("Hello!\n"+Integer.toString(mCount));
        Intent intent = new Intent(this, MainActivity2.class);
        String message = Integer.toString(mCount);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /*
    * Increments the number in the TextView when the COUNT button is clicked.
    *
    * @param view The view that triggered this onClick handler.
    *             Since the count always appears in the TextView,
    *             the passed in view is not used.
    */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}
