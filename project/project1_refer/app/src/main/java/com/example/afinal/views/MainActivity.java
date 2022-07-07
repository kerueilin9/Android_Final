package com.example.afinal.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.afinal.MainApplication;
import com.example.afinal.R;
import com.example.afinal.database.DataModel;
import com.example.afinal.model.NotificationInfo;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private RecyclerView notificationView;
    private NotificationAdapter notificationAdapter;
    private ArrayList<NotificationInfo> notificationList = new ArrayList<>();
    private DataModel dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        MainApplication.setMainActivityContext(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        setContentView(R.layout.activity_main);

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

        notificationView = (RecyclerView) findViewById(R.id.recyclerView);
        notificationView.setLayoutManager(new LinearLayoutManager(this));
        notificationView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        dataModel = new DataModel(this);
        dataModel.readData();
    }

    public void setNotificationList(ArrayList<NotificationInfo> mNotificationList){
        notificationList = mNotificationList;
        notificationView.setAdapter(notificationAdapter);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(notificationView);
        notificationAdapter = new NotificationAdapter(this, notificationList);
        notificationView.setAdapter(notificationAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 設置要用哪個menu檔做為選單
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_message) {

            Toast.makeText(this, "Filter Message", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.action_settings) {

            Toast.makeText(this, "Resend", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.action_name) {
            Toast.makeText(this, "Notifications are sorted by APP's name.", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_time) {
            Toast.makeText(this, "Notifications are sorted by time.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isPurview(Context context) {
        Set<String> packageNames = NotificationManagerCompat.getEnabledListenerPackages(context);
        return packageNames.contains(context.getPackageName());
    }

    @SuppressLint("NotifyDataSetChanged")
    private void deleteNotification(NotificationInfo notificationInfo){
        notificationList.remove(notificationInfo);
        notificationAdapter.notifyDataSetChanged();

        dataModel.deleteDate(notificationInfo.getId());
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            deleteNotification(notificationList.get(viewHolder.getAdapterPosition()));
        }
    };
}