package com.example.a109590043_hw6_042;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String toast = "";
    String c1 = "";
    String c2 = "";
    String c3 = "";
    String c4 = "";
    String c5 = "";

    Button Btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn1 = findViewById(R.id.button);
        CheckBox CB1 = findViewById(R.id.checkBox);
        CheckBox CB2 = findViewById(R.id.checkBox2);
        CheckBox CB3 = findViewById(R.id.checkBox3);
        CheckBox CB4 = findViewById(R.id.checkBox4);
        CheckBox CB5 = findViewById(R.id.checkBox5);
        toast = "Toppings: ";

        CB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    c1 = String.valueOf(CB1.getText()+" ");
                } else {
                    c1 = "";
                }
            }
        });
        CB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    c2 = String.valueOf(CB2.getText()+" ");
                } else {
                    c2 = "";
                }
            }
        });
        CB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    c3 = String.valueOf(CB3.getText()+" ");
                } else {
                    c3 = "";
                }
            }
        });
        CB4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    c4 = String.valueOf(CB4.getText()+" ");
                } else {
                    c4 = "";
                }
            }
        });
        CB5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    c5 = String.valueOf(CB5.getText()+" ");
                } else {
                    c5 = "";
                }
            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toppings: " + c1 + c2 + c3 + c4 + c5, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}