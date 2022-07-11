package com.example.android.DB;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class mRoomViewModel extends AndroidViewModel {
    private final mRepository repository;

    public mRoomViewModel(Application application){
        super(application);
        repository = new mRepository(application);
    }

    public LiveData<List<mRoomItem>> getAllItemLive() {
        return repository.getAllItemLive();
    }
    LiveData<List<mRoomItem>> searchItem(String patten) {
        return repository.searchItem(patten);
    }

    public void insertR(mRoomItem... roomItems) {
        repository.insertR(roomItems);
    }
    public void updateR(mRoomItem... roomItems) {
        repository.updateR(roomItems);
    }
    public void deleteR(mRoomItem... roomItems) {
        repository.deleteR(roomItems);
    }
    public void deleteAllR() { repository.deleteAllR(); }

}