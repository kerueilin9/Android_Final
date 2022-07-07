package com.example.hw7_t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hw7_t.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
    }

    public void button1(View view) {
        Intent intent = new Intent(this, MainActivity_order1.class);
        startActivity(intent);
    }

    public void button2(View view) {
        Intent intent = new Intent(this, MainActivity_order2.class);
        startActivity(intent);
    }

    public void button3(View view) {
        Intent intent = new Intent(this, MainActivity_order3.class);
        startActivity(intent);
    }
}