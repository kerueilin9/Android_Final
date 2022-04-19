package com.example.android;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<String> mRecipesList = new LinkedList<>();

    private RecyclerView recyclerView;
    private MyRecycle recipesRecycle;
    private ActivityMainBinding binding;

    public int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecipesList.addLast("+ Student "+String.valueOf(i++));
                recyclerView = findViewById(R.id.recyclerview);
                recipesRecycle = new MyRecycle(MainActivity.this, mRecipesList);
                recyclerView.setAdapter(recipesRecycle);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });

        for (i = 0; i < 10; i++){
            mRecipesList.addLast("Student "+String.valueOf(i));
        }

        recyclerView = findViewById(R.id.recyclerview);
        recipesRecycle = new MyRecycle(this, mRecipesList);
        recyclerView.setAdapter(recipesRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}