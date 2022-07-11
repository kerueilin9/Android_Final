package com.example.android.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.android.adapter.main_adapter;
import com.example.android.DB.mRoomItem;
import com.example.android.DB.mRoomViewModel;
import com.example.android.DB.mRepository;
import com.example.android.MainActivity;

public class NotificationCatchService extends NotificationListenerService {

    main_adapter adapter;
    mRoomViewModel roomViewModel;
    Context context;

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        adapter = new main_adapter();
//    }
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn){
        roomViewModel = new ViewModelProvider((MainActivity)context).get(mRoomViewModel.class);
        Bundle extras = sbn.getNotification().extras;
        String packageName= sbn.getPackageName();
        String title = extras.getString(Notification.EXTRA_TITLE);
        String text = extras.getString(Notification.EXTRA_TEXT);
        long timestamp = sbn.getPostTime();
        mRoomItem roomItem = new mRoomItem(title, text, packageName, timestamp);
        if(!packageName.equals("com.example.android")){
            try{
                roomViewModel.insertR(roomItem);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn){

    }
}
