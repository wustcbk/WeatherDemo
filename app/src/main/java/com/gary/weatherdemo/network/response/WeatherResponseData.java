package com.gary.weatherdemo.network.response;

import com.gary.weatherdemo.model.WeatherAllResult;
import com.gary.weatherdemo.model.WeatherCurrentResult;
import com.gary.weatherdemo.network.response.base.BaseResponseData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//api2:
//https://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=3b6729d0c40f23fde7c55ae90ee0921d&extensions=base&output=JSON
//    {"status":"1", "count":"1", "info":"OK", "infocode":"10000", "forecasts":[
//            {"city":"东城区", "adcode":"110101","province":"北京","reporttime":"2018-10-21 08:00:00",
//             "casts":[
//                {"date":"2018-10-21","week":"7","dayweather":"多云","nightweather":"多云","daytemp":"17","nighttemp":"6","daywind":"东南","nightwind":"北","daypower":"≤3","nightpower":"≤3"},
//                {"date":"2018-10-22","week":"1","dayweather":"多云","nightweather":"晴","daytemp":"19","nighttemp":"5","daywind":"西北","nightwind":"西","daypower":"≤3","nightpower":"≤3"},
//                {"date":"2018-10-23","week":"2","dayweather":"晴","nightweather":"晴","daytemp":"19","nighttemp":"4","daywind":"西南","nightwind":"西南","daypower":"≤3","nightpower":"≤3"},
//                {"date":"2018-10-24","week":"3","dayweather":"晴","nightweather":"晴","daytemp":"19","nighttemp":"6","daywind":"东南","nightwind":"东南","daypower":"≤3","nightpower":"≤3"}]}]}

//api1:
//https://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=3b6729d0c40f23fde7c55ae90ee0921d&extensions=base&output=JSON
//    {"status":"1","count":"1","info":"OK","infocode":"10000","lives":[
//                    {"province":"北京","city":"东城区", "adcode":"110101", "weather":"多云", "temperature":"13", "winddirection":"东北", "windpower":"5", "humidity":"54", "reporttime":"2018-10-21 11:00:00"}]}

public class WeatherResponseData extends BaseResponseData {
    @SerializedName("forecasts")
    @Expose
    private final WeatherAllResult weatherAllResult = null;

    @SerializedName("lives")
    @Expose
    private final WeatherCurrentResult weatherCurrentResult = null;

    public WeatherAllResult getWeatherAllResult() {
        return weatherAllResult;
    }

    public WeatherCurrentResult getWeatherCurrentResult() {
        return weatherCurrentResult;
    }
}
