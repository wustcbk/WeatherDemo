package com.gary.weatherdemo.base;

import android.app.Application;

/**
 * Created by GaryCao on 2018/10/25.
 */
public class MyApplication extends Application {
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }
}
