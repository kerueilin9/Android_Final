package com.example.data_pt1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insertW(Word... words);

    @Update
    void updateW(Word... words);

    @Delete
    void deleteW(Word... words);

    @Query("DELETE FROM WORD")
    void deleteAllW();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
//    List<Word> getAllW();
    LiveData<List<Word>> getAllW_live();
}
