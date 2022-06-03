package com.example.android;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    ActivityMainBinding binding;
    RoomViewModel roomViewModel;
    RecyclerView recyclerView;
    mRecycleAdapter adapter;
    private LiveData<List<mRoomItem>> searchedItems;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBar.toolbar);

        AppCompatDelegate.setDefaultNightMode
                (AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new mRecycleAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        searchedItems = roomViewModel.getAllItemLive();
        searchedItems.observe(this, mRoomItems -> {
            adapter.setAllItem(MainActivity.this, mRoomItems);
            this.setTitle(getString(R.string.My_Document) + " (" + (adapter.getItemCount()) + ")");
            adapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(0);
            //Toast.makeText(getApplication(), String.valueOf(adapter.getItemCount()), Toast.LENGTH_SHORT).show();
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, binding.appBar.toolbar, R.string.nav_open,
                R.string.nav_close);
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void takeAPic(View view) {
//        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

//        if (takePicture.resolveActivity(getPackageManager()) != null) {
//            startActivity(takePicture);
//        } else {
//            Log.d("ImplicitIntents", "Can't handle this intent!");
//        }
        mRoomItem roomItem = new mRoomItem(R.drawable.ic_baseline_image_24, getString(R.string.Document) + " " + (adapter.getItemCount() + 1));
        roomViewModel.insertR(roomItem);
    }

    public void addPic(View view) {

    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setMaxWidth(1000);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public boolean onQueryTextChange(String s) {
                String patten = s.trim();
                searchedItems.removeObservers(MainActivity.this);
                searchedItems = roomViewModel.searchItem(patten);
                searchedItems.observe(MainActivity.this, mRoomItems -> {
                    adapter.setAllItem(MainActivity.this, mRoomItems);
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(0);
                });
                return true;
            }
        });
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mode:
            case R.id.edit:
                Intent intent = new Intent(this, MainActivity_edit.class);
                startActivity(intent);
                return true;
            case R.id.Delete_All:
                AlertDialog.Builder alert_delete = new AlertDialog.Builder(MainActivity.this);
                alert_delete.setIcon(R.drawable.ic_baseline_error_24);
                alert_delete.setTitle(R.string.Delete_all_item);
                alert_delete.setMessage(R.string.This_action_will_delete_all_item);
                alert_delete.setPositiveButton("OK", (dialog, which) -> roomViewModel.deleteAllR());
                alert_delete.setNegativeButton("CANCEL", (dialogInterface, i) -> {

                });
                alert_delete.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            default:
                drawer.closeDrawer(GravityCompat.START);
                return false;
        }
    }

    public void display(String str){
        Toast.makeText(getApplication(), str, Toast.LENGTH_SHORT).show();
    }
}
