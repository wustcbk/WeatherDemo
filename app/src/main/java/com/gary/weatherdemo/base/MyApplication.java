package com.gary.weatherdemo.base;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

/**
 * Created by GaryCao on 2018/10/25.
 */
public class MyApplication extends MultiDexApplication {
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
