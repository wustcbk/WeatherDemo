package com.gary.weatherdemo.network.response;

import com.gary.weatherdemo.model.WeatherLiveResult;
import com.gary.weatherdemo.network.response.base.BaseResponseData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//api1:
//https://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=3b6729d0c40f23fde7c55ae90ee0921d&extensions=base&output=JSON
//    {"status":"1","count":"1","info":"OK","infocode":"10000","lives":[
//                    {"province":"北京","city":"东城区", "adcode":"110101", "weather":"多云", "temperature":"13", "winddirection":"东北", "windpower":"5", "humidity":"54", "reporttime":"2018-10-21 11:00:00"}]}
/**
 * Created by GaryCao on 2018/10/25.
 */
public class WeatherLivesResponseData extends BaseResponseData {
    @SerializedName("lives")
    @Expose
    private final List<WeatherLiveResult> weatherLiveResultList = null;

    public WeatherLiveResult getWeatherLiveResult() {
        return weatherLiveResultList==null ? null: weatherLiveResultList.get(0);
    }
}
