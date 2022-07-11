package com.example.android.DB;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class mRepository {
    private final mRoomDao roomDao;
    private final LiveData<List<mRoomItem>> allItemLive;

    public mRepository(Context context) {
        mRoomDB roomDatabase = mRoomDB.getDatabase(context.getApplicationContext());
        roomDao = roomDatabase.getRoomDao();
        allItemLive = roomDao.getAllW_live();
    }

    LiveData<List<mRoomItem>> getAllItemLive() {
        return allItemLive;
    }
    LiveData<List<mRoomItem>> searchItem(String patten) {
        return roomDao.searchItem("%" + patten + "%");
    }

    public void insertR(mRoomItem... roomItems) {
        new InsertAsyncTask(roomDao).execute(roomItems);
    }
    void updateR(mRoomItem... roomItems) {
        new UpdateAsyncTask(roomDao).execute(roomItems);
    }
    void deleteR(mRoomItem... roomItems) {
        new DeleteAsyncTask(roomDao).execute(roomItems);
    }
    void deleteAllR() { new DeleteAllAsyncTask(roomDao).execute(); }

    public void insertDB(mRoomItem roomItem) {
    }


    static class InsertAsyncTask extends AsyncTask<mRoomItem, Void, Void> {
        private final mRoomDao roomDao;

        public InsertAsyncTask(mRoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(mRoomItem... roomItems) {
            roomDao.insertW(roomItems);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<mRoomItem, Void, Void> {
        private final mRoomDao roomDao;

        public UpdateAsyncTask(mRoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(mRoomItem... roomItems) {
            roomDao.updateW(roomItems);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<mRoomItem, Void, Void> {
        private final mRoomDao roomDao;

        public DeleteAsyncTask(mRoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(mRoomItem... roomItems) {
            roomDao.deleteW(roomItems);
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<mRoomItem, Void, Void> {
        private final mRoomDao roomDao;

        public DeleteAllAsyncTask(mRoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(mRoomItem... roomItems) {
            roomDao.deleteAllW();
            return null;
        }
    }
}
