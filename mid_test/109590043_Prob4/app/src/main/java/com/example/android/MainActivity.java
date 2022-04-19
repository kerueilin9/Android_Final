package com.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.includeMain.toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.draw);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, binding.includeMain.toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        binding.includeMain.includeMainAppbar.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog =
                        new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("這是標題");
                alertDialog.setMessage("文字在此");
                alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),"確定",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNeutralButton("取消",(dialog, which) -> {
                    Toast.makeText(getBaseContext(),"取消",Toast.LENGTH_SHORT).show();
                });
                alertDialog.setCancelable(false);
                alertDialog.show();
            }
        });


    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_send:
                Toast.makeText(getBaseContext(),"確定",Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(getBaseContext(),"false",Toast.LENGTH_SHORT).show();
                return true;
        }

    }
}