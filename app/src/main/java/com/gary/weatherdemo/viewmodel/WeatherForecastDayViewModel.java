package com.gary.weatherdemo.viewmodel;

import com.gary.weatherdemo.model.WeatherForecastData;

public class WeatherForecastDayViewModel {
    public final WeatherForecastData weatherForecast;

    public WeatherForecastDayViewModel(WeatherForecastData WeatherForecastData) {
        weatherForecast = WeatherForecastData;
    }

    //==============================================================================================
    //for test //TBD :需考虑并发和耗时
    private void insertCityForecastInfo(){
        /*CityForecastEntity entity = new CityForecastEntity(weatherForecast);
        entity.setAdcode("440300"); //深圳:adcode:440300 citycode:0755
        entity.setCityName("深圳");
        CityForecastDatabase.getInstance().getDb().cityForecastDAO().insert(entity);*/
    }
}
