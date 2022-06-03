package com.example.android;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class mRoomItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "img")
    private int imgResource;

    @ColumnInfo(name = "title")
    private String title;

    mRoomItem(){}

    public mRoomItem(int imgResource, String title){
        this.imgResource = imgResource;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
