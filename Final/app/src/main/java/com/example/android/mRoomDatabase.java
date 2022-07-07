package com.example.android;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {mRoomItem.class}, version = 2,exportSchema = false)
public abstract class mRoomDatabase extends RoomDatabase {

    private static mRoomDatabase INSTANCE;
    static synchronized  mRoomDatabase getDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), mRoomDatabase.class, "my_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    public abstract mRoomDao getRoomDao();
}
