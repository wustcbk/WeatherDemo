package com.gary.weatherdemo.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.gary.weatherdemo.base.MyApplication;

public class WeatherConfig {
    private static final String WEATHER_CONFIG = "weather_config";
    private static final String KEY_DEFAULT_CITY_ADCODE = "def_adcode";
    private final String VALUE_DEFAULT_CITY_ADCODE = "";

    private Context context;
    private static SharedPreferences sharedPreferences;

    private static WeatherConfig weatherConfig;

    public synchronized static WeatherConfig getInstance(Context context) {
        if (weatherConfig == null) {
            weatherConfig = new WeatherConfig(context);
        }
        return weatherConfig;
    }

    public WeatherConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(WEATHER_CONFIG, Context.MODE_PRIVATE);
    }

    public String getKeyDefaultCityAdcode() {
        return sharedPreferences.getString(KEY_DEFAULT_CITY_ADCODE, VALUE_DEFAULT_CITY_ADCODE);
    }

    public void setKeyDefaultCityAdcode(String adcode) {
        sharedPreferences.edit().putString(KEY_DEFAULT_CITY_ADCODE, adcode);
    }

    //===================================================================================================
    //for test
    /*默認天氣城市設置為：深圳*/
    private void setShenzhenForecastWeather() {
        //深圳:adcode:440300 citycode:0755
        WeatherConfig.getInstance(MyApplication.getInstance().getApplicationContext()).setKeyDefaultCityAdcode("440300");
    }
}
