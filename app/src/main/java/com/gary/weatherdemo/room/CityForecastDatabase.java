package com.gary.weatherdemo.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by GaryCao on 2018/10/25.
 */
@Database(entities = {CityForecastEntity.class}, version = 1, exportSchema = false)
public abstract class CityForecastDatabase extends RoomDatabase {
    public static final String WEATHER_DB_NAME = "weather_db";

    public abstract CityForecastDAO cityForecastDAO();
}