package com.example.afinal.model;

public class NotificationInfo {
    private int id;
    private String packageName;
    private String title;
    private String text;

    public NotificationInfo() { }

    public void setId(int id) {
        this.id = id;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}
