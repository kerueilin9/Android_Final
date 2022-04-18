package com.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.android.databinding.ActivityMainPage1Binding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity_page1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ActivityMainPage1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page1);
        binding = ActivityMainPage1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.includePage1.toolbar2);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.draw);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, binding.includePage1.toolbar2, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.draw);
        return false;
    }
}