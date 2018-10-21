package com.gary.weatherdemo.room;

import com.gary.weatherdemo.model.WeatherForecastData;

//  高德天气预报数据表实体类
@Entity(tableName = "city_forecast")
public class CityForecastEntity {
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "city_name")
    private String city_name;

    @ColumnInfo(name = "adcode")
    private String adcode;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "week")
    private String week;

    @ColumnInfo(name = "dayweather")
    private String dayweather;

    @ColumnInfo(name = "nightweather")
    private String nightweather;

    @ColumnInfo(name = "daywind")
    private String daywind;

    @ColumnInfo(name = "nightwind")
    private String nightwind;

    @ColumnInfo(name = "daypower")
    private String daypower;

    @ColumnInfo(name = "nightpower")
    private String nightpower;

    public void setCityName(String cityname) {
        city_name = cityname;
    }

    public String getCityName() {
        return city_name;
    }

    public void setForecastDate(String date) {
        this.date = date;
    }

    public String getForecastDate() {
        return date;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public void setDayWeather(String dayweather) {
        this.dayweather = dayweather;
    }

    public void setNightWeather(String nightweather) {
        this.nightweather = nightweather;
    }

    public void setDayWind(String daywind) {
        this.daywind = daywind;
    }

    public void setNightWind(String nightwind) {
        this.nightwind = nightwind;
    }

    public void setDayPower(String daypower) {
        this.daypower = daypower;
    }

    public void setNightPower(String nightpower) {
        this.daypower = daypower;
    }

    public CityForecastEntity(WeatherForecastData data) {
        this.date = data.date;
        this.dayweather = data.dayweather;
        this.nightweather = data.nightweather;
        this.daywind = data.daywind;
        this.nightwind = data.nightwind;
        this.daypower = data.nightpower;
    }
}