package com.gary.weatherdemo.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CityForecastEntity.class}, version = 1)
public abstract class CityForecastDatabase extends RoomDatabase {
    public static final String CITY_FORCAST_DB_NAME = "city_db";

    public abstract CityForecastDAO cityForecastDAO();
}