package com.example.afinal.views;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.MainApplication;
import com.example.afinal.R;
import com.example.afinal.model.NotificationInfo;
import com.example.afinal.receiver.AlarmBroadcastReceiver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class NotificationAdapter extends
        RecyclerView.Adapter<NotificationAdapter.WordViewHolder> implements ItemTouchHelperAdapter{
    private ArrayList<NotificationInfo> notificationList;
    private final LayoutInflater mInflater;
    private ViewGroup parent;
    private NotificationManager mNotificationManager;
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(notificationList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        notificationList.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public NotificationAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View mItemView = mInflater.inflate(
                R.layout.notification_row, parent, false);
        this.parent = parent;
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.WordViewHolder holder, int position) {
        holder.titleView.setText(notificationList.get(position).getTitle());
        holder.textView.setText(notificationList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public final TextView titleView;
        public final TextView textView;
        final NotificationAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, NotificationAdapter adapter) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title);
            textView = itemView.findViewById(R.id.text);
            itemView.setOnLongClickListener((View.OnLongClickListener) this);
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            scheduleNotification(this.getAdapterPosition());
            return true;
        }
    }

    public NotificationAdapter(Context context, ArrayList<NotificationInfo> notificationList) {
        mInflater = LayoutInflater.from(context);
        this.notificationList = notificationList;
        createNotificationChannel();
    }

    public void scheduleNotification(int position){
        final Calendar myCalender = Calendar.getInstance();
        int hour = myCalender.get(Calendar.HOUR_OF_DAY);
        int minute = myCalender.get(Calendar.MINUTE);


        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (view.isShown()) {
                    myCalender.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    myCalender.set(Calendar.MINUTE, minute);

                    sendNotification(hourOfDay, minute, position);
                }
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(parent.getContext(), android.R.style.Theme_Holo_Light_Dialog_NoActionBar, myTimeListener, hour, minute, true);
        timePickerDialog.setTitle("Choose Recall time:");
        timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        timePickerDialog.show();
    }

    public void sendNotification(int hour, int minute, int position){
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.setTimeInMillis(System.currentTimeMillis());

        int setHour = hour;
        int setMinute = minute;

        int nowHour = calendarNow.get(Calendar.HOUR_OF_DAY);
        int nowMinute = calendarNow.get(Calendar.MINUTE);

        if(nowHour > setHour || ((nowHour == setHour) && (nowMinute == setMinute))){
            setHour += 24;
        }

        Calendar calendarSet = Calendar.getInstance();
        calendarSet.set(Calendar.HOUR_OF_DAY, setHour);
        calendarSet.set(Calendar.MINUTE, setMinute);
        calendarSet.set(Calendar.SECOND, 0);
        calendarSet.set(Calendar.MILLISECOND, 0);

        Intent contentIntent = new Intent(MainApplication.getMainActivityContext(), AlarmBroadcastReceiver.class);
        contentIntent.putExtra("title", notificationList.get(position).getTitle());
        contentIntent.putExtra("text", notificationList.get(position).getText());

        contentIntent.setAction("CLOCK_IN");
        AlarmManager alarmManager = (AlarmManager)MainApplication.getMainActivityContext().
                getSystemService((Context.ALARM_SERVICE));

        PendingIntent contentPendingIntent = PendingIntent.getBroadcast(MainApplication.getMainActivityContext(), 0, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long alarmSeconds = calendarSet.getTimeInMillis() - System.currentTimeMillis();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + alarmSeconds, contentPendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + alarmSeconds, contentPendingIntent);
        }
    }

    public void createNotificationChannel() {
        // Create a notification manager object.
        mNotificationManager =
                (NotificationManager) MainApplication.getMainActivityContext().
                        getSystemService(Context.NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Stand up notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifies every 15 minutes to stand up and walk");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}