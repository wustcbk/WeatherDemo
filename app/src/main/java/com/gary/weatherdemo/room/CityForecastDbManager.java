package com.gary.weatherdemo.room;

import android.arch.persistence.room.Room;

import com.gary.weatherdemo.base.MyApplication;

//TBD 耗时操作如何处理
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
                CityForecastDatabase.class, CityForecastDatabase.CITY_FORCAST_DB_NAME).build();
        return db;
    }
}