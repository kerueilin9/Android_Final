package com.example.android;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {
    private final mRepository repository;

    public RoomViewModel (Application application){
        super(application);
        repository = new mRepository(application);
    }

    LiveData<List<mRoomItem>> getAllItemLive() {
        return repository.getAllItemLive();
    }
    LiveData<List<mRoomItem>> searchItem(String patten) {
        return repository.searchItem(patten);
    }

    void insertR(mRoomItem... roomItems) {
        repository.insertR(roomItems);
    }
    void updateR(mRoomItem... roomItems) {
        repository.updateR(roomItems);
    }
    void deleteR(mRoomItem... roomItems) {
        repository.deleteR(roomItems);
    }
    void deleteAllR() { repository.deleteAllR(); }
}
