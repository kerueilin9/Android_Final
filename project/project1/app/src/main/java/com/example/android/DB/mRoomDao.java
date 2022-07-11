package com.example.android.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface mRoomDao {
    @Insert
    void insertW(mRoomItem... roomItems);

    @Update
    void updateW(mRoomItem... roomItems);

    @Delete
    void deleteW(mRoomItem... roomItems);

    @Query("DELETE FROM MROOMITEM")
    void deleteAllW();

    @Query("SELECT * FROM MROOMITEM ORDER BY ID DESC")
    LiveData<List<mRoomItem>> getAllW_live();

    @Query("SELECT * FROM MROOMITEM WHERE title LIKE :patten ORDER BY ID DESC")
    LiveData<List<mRoomItem>> searchItem(String patten);
}