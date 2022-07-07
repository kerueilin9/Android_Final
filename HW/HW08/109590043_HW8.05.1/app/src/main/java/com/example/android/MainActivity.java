package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    int level;
    //ImageView imageView;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //imageView = findViewById(R.id.imageView);
        level = 3;
        binding.imageView.setImageLevel(level);

//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(level > 0)
//                    binding.imageView.setImageLevel(--level);
//            }
//        });
//
//        binding.button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(level < 6)
//                    binding.imageView.setImageLevel(++level);
//            }
//        });
    }

    public void sub(View view){
        if(level > 0)
            binding.imageView.setImageLevel(--level);
    }

    public void plus(View view){
        if(level < 6)
            binding.imageView.setImageLevel(++level);
    }
}