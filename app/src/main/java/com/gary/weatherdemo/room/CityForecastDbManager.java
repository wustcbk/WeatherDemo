package com.gary.weatherdemo.room;

import android.arch.persistence.room.Room;

import com.gary.weatherdemo.base.MyApplication;

/**
 * Created by GaryCao on 2018/10/25.
 */
//TBD DB耗时操作如何处理:RXJava(推荐) ? HandleThread(UI订阅复杂)? AsyncTask(阻塞)?
public class CityForecastDbManager {
    private static CityForecastDbManager cityForecastDbManager;
    public synchronized static CityForecastDbManager getInstance() {
        if (cityForecastDbManager == null) {
            cityForecastDbManager = new CityForecastDbManager();
        }
        return cityForecastDbManager;
    }

    public CityForecastDatabase getDb(){
        CityForecastDatabase db = Room.databaseBuilder(MyApplication.getInstance(),
                CityForecastDatabase.class, CityForecastDatabase.WEATHER_DB_NAME).build();
        return db;
    }
}