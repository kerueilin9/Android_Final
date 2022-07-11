package com.example.android.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class mRoomItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "packageName")
    private String packageName;

    @ColumnInfo(name = "time")
    private Long time;

    mRoomItem(){}

    public mRoomItem(String title, String content, String packageName, Long time){
        this.title = title;
        this.content = content;
        this.packageName = packageName;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
