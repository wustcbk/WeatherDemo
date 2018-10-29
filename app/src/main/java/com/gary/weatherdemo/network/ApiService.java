package com.gary.weatherdemo.network;

import com.gary.weatherdemo.network.response.WeatherAllResponseData;
import com.gary.weatherdemo.network.response.WeatherLivesResponseData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface ApiService {
    //https://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=3b6729d0c40f23fde7c55ae90ee0921d&extensions=base&output=JSON
    @FormUrlEncoded
    @POST(ApiContants.AMAP_WEATHER_GET)
    Observable<WeatherLivesResponseData> livesweatherPost(
            @Field("city") String city,
            @Field("key") String key,
            @Field("extensions") String extensions,
            @Field("output") String output
    );

    @FormUrlEncoded
    @POST(ApiContants.AMAP_WEATHER_GET)
    Observable<WeatherAllResponseData> allweatherPost(
            @Field("city") String city,
            @Field("key") String key,
            @Field("extensions") String extensions,
            @Field("output") String output
    );

    @GET
    Observable<WeatherAllResponseData> weatherGet(
            @Url String url);
}
