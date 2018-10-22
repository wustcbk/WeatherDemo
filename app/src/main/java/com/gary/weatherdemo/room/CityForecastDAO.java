package com.gary.weatherdemo.room;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

public interface  CityForecastDAO {
    @Query("SELECT * FROM CityForecastEntity")
    List<CityForecastEntity> getAll();

    @Query("SELECT * FROM CityForecastEntity WHERE id IN (:ids)")
    List<CityForecastEntity> getAllByIds(long[] ids);

    @Insert
    void insert(CityForecastEntity... entities);

    @Delete
    void delete(CityForecastEntity entity);

    @Update
    void update(CityForecastEntity entity);
}