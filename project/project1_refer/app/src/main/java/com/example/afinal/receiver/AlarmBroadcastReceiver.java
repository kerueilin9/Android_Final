package com.example.afinal.receiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.afinal.R;
import com.example.afinal.views.MainActivity;

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("CLOCK_IN")){
            String title = intent.getStringExtra("title");
            String text = intent.getStringExtra("text");

            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setDefaults(NotificationCompat.DEFAULT_ALL);

            Intent mIntent=new Intent(context, MainActivity.class);
            PendingIntent mPendingIntent=PendingIntent.getActivity(context, 0, mIntent,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(mPendingIntent);
            manager.notify(0, builder.build());
        }
    }
}
