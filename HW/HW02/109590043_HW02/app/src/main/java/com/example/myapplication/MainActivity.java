package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int mycount = 0;
    private TextView myShowCount;
//    private Button zero_BT;
//    private Button count_BT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myShowCount = (TextView) findViewById(R.id.show_count);
//        zero_BT = (Button) findViewById(R.id.button_zero);
//        count_BT = (Button) findViewById(R.id.button_count);
    }

    public void ShowToast(View view) {
        Toast toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_LONG);
        toast.show();
    }

    public void countUp(View view) {
        mycount++;
        if(myShowCount != null){
            myShowCount.setText(Integer.toString(mycount));
        }
        if(mycount != 0){
            binding.buttonZero.setBackgroundColor(Color.GREEN);
        }
        if(mycount % 2 != 0){
            view.setBackgroundColor(Color.rgb(3,218,197));
        } else {
            view.setBackgroundColor(Color.rgb(187,134,252));
        }
    }

    public void reset(View view) {
        mycount = 0;
        if(myShowCount != null){
            myShowCount.setText(Integer.toString(mycount));
            binding.buttonZero.setBackgroundColor(Color.rgb(170,170,170));
            binding.buttonCount.setBackgroundColor(Color.rgb(187,134,252));
        }
    }



}