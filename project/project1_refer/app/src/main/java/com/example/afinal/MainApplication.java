package com.example.afinal;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {
    private static Context mainActivityContext;
    private static Context dataModelContext;

    public static Context getMainActivityContext(){
        return mainActivityContext;
    }

    public static void setMainActivityContext(Context mContext) {
        mainActivityContext = mContext;
    }

    public static Context getDataModelContext(){
        return dataModelContext;
    }

    public static void setDataModelContext(Context mContext) {
        dataModelContext = mContext;
    }
}
