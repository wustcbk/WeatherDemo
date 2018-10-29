package com.gary.weatherdemo.network;

import com.gary.weatherdemo.network.response.WeatherAllResponseData;
import com.gary.weatherdemo.network.response.WeatherLivesResponseData;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by GaryCao on 2018/10/25.
 */
public class DataRequestRepos {
    private static DataRequestRepos dataRequestRepos;
    private static ApiService apiService;

    public DataRequestRepos() {
        createApiClient();
    }

    private ApiService createApiClient() {
        if (apiService == null) {
            /*GoF3: 抽象工厂*/
            apiService = RetrofitFactory.getInstance().create(ApiService.class);
        }
        return apiService;
    }

    public synchronized static DataRequestRepos getInstance() {
        if (dataRequestRepos == null) {
            dataRequestRepos = new DataRequestRepos();
        }
        return dataRequestRepos;
    }

    /*高德天气：当前天气查询接口*/
    public Observable<WeatherLivesResponseData> liveWeatherPost(final String adcode) {
        return apiService.livesweatherPost(adcode,
                ApiContants.AMAP_USER_KEY_VALUE,
                ApiContants.AMAP_USER_EXTENSION_VALUE_BASE,
                ApiContants.AMAP_USER_OUTPUT_VALUE)
                .subscribeOn(Schedulers.io());
    }

    /*高德天气：预报天气查询接口*/
    public Observable<WeatherAllResponseData> forecastWeatherPost(final String adcode) {
        return apiService.allweatherPost(adcode,
                ApiContants.AMAP_USER_KEY_VALUE,
                ApiContants.AMAP_USER_EXTENSION_VALUE_ALL,
                ApiContants.AMAP_USER_OUTPUT_VALUE)
                .subscribeOn(Schedulers.io());
    }

    /*高德天气：预报天气查询接口*/
    public Observable<WeatherAllResponseData> forecastWeatherGet(final String adcode) {
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=3b6729d0c40f23fde7c55ae90ee0921d&extensions=base&output=JSON\n";
        return apiService.weatherGet(url).subscribeOn(Schedulers.io());
    }

    //===================================================================================================
    //for test
    /*高德天气：当前天气查询接口:深圳*/
    private void getShenzhenForecastWeather() {
        DataRequestRepos.getInstance().liveWeatherPost("440300");//深圳:adcode:440300 citycode:0755
    }
}