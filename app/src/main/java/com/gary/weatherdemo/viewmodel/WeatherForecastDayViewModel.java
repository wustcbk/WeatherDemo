package com.gary.weatherdemo.viewmodel;

import com.gary.weatherdemo.model.WeatherForecastData;
import com.gary.weatherdemo.room.CityForecastDbManager;
import com.gary.weatherdemo.room.CityForecastEntity;

public class WeatherForecastDayViewModel {
    public final WeatherForecastData weatherForecastData;

    public WeatherForecastDayViewModel(WeatherForecastData WeatherForecastData) {
        weatherForecastData = WeatherForecastData;
    }

    //==============================================================================================
    //for test //TBD :需考虑并发和耗时
    private void insertCityForecastInfo(){
        CityForecastEntity entity = new CityForecastEntity(weatherForecastData);
        entity.setAdcode("440300"); //深圳:adcode:440300 citycode:0755
        entity.setCityName("深圳");
        CityForecastDbManager.getInstance().getDb().cityForecastDAO().insert(entity);
    }
}
