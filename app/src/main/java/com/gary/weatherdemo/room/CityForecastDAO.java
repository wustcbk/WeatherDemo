package com.gary.weatherdemo.room;

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