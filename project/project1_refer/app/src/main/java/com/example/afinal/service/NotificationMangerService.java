package com.example.afinal.service;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import com.example.afinal.database.DataModel;


public class NotificationMangerService extends NotificationListenerService {
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn){
        DataModel dataModel = new DataModel(this);
        dataModel.getNewNotification(sbn);
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn){

    }
}
