package com.example.afinal.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import com.example.afinal.database.DataModel;
import com.example.afinal.views.MainActivity;


public class NotificationMangerService extends NotificationListenerService {

    MainActivity mainActivity = new MainActivity();
    Context context;
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn){
        try{
            DataModel dataModel = new DataModel(this);
            dataModel.getNewNotification(sbn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn){

    }
}
