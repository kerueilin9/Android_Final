package com.example.android.selection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int[] checkBoxIdList = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxIdList[0] = R.id.first_checkBox;
        checkBoxIdList[1] = R.id.second_checkBox;
        checkBoxIdList[2] = R.id.third_checkBox;
        checkBoxIdList[3] = R.id.fourth_checkBox;
        checkBoxIdList[4] = R.id.fifth_checkBox;
    }

    public void onSubmit(View view) {
        String message = "Toppings: ";
        for (int i = 0; i < 5; i++){
            CheckBox checkBox = (CheckBox) findViewById(checkBoxIdList[i]);
            if(checkBox.isChecked()){
                message += checkBox.getText();
                message += " ";
            }
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}