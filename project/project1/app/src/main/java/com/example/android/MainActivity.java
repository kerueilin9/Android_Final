package com.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.DB.mRoomViewModel;
import com.example.android.databinding.ActivityMainBinding;
import com.example.android.adapter.main_adapter;
import com.example.android.DB.mRoomItem;
import com.example.android.service.NotificationCatchService;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    mRoomViewModel roomViewModel;
    RecyclerView recyclerView;
    main_adapter adapter;
    //NotificationCatchService service;
    private LiveData<List<mRoomItem>> searchedItems;

    @SuppressLint({"ResourceType", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MainApplication.setMainActivityContext(this);
//
//        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        roomViewModel = new ViewModelProvider(this).get(mRoomViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new main_adapter();
        //service = new NotificationCatchService();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //service.getContext(MainActivity.this);
        //====================================================================================================
        //mRoomItem roomItem = new mRoomItem("title", "text", "packageName", Long.parseLong("123"));
        //roomViewModel.insertR(roomItem);
        //====================================================================================================
        searchedItems = roomViewModel.getAllItemLive();
        searchedItems.observe(this, mRoomItems -> {
            adapter.setAllItem(MainActivity.this, mRoomItems);
            adapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(0);
        });

        if(!isPurview(this)){ // 檢查權限是否開啟，未開啟則開啟對話框
            // 對話框按鈕事件
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.app_name)
                    .setMessage("請啟用通知欄擷取權限")
                    .setIcon(R.mipmap.ic_launcher_round)
                    .setOnCancelListener(dialog -> { // 對話框取消事件
                        finish();
                    })
                    .setPositiveButton("前往", (dialog, which) -> {
                                // 跳轉自開啟權限畫面，權限開啟後通知欄擷取服務將自動啟動。
                                startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                            }
                    ).show();
        }


    }

    public Context getContext() {
        return MainActivity.this;
    }


    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private boolean isPurview(Context context) {
        Set<String> packageNames = NotificationManagerCompat.getEnabledListenerPackages(context);
        return packageNames.contains(context.getPackageName());
    }
}