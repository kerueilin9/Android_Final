package com.example.android.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {mRoomItem.class}, version = 1,exportSchema = false)
public abstract class mRoomDB extends RoomDatabase {

    private static mRoomDB INSTANCE;
    static synchronized  mRoomDB getDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), mRoomDB.class, "my_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    public abstract mRoomDao getRoomDao();
}
