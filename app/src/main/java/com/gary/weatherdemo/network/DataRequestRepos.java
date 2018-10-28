package com.gary.weatherdemo.network;

import com.gary.weatherdemo.network.response.WeatherLivesResponseData;

import rx.Observable;
import rx.schedulers.Schedulers;

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
            apiService = RetrofitManager.getInstance().create(ApiService.class);
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
    public Observable<WeatherLivesResponseData> liveWeatherGet(final String adcode) {
        return apiService.weatherGet(adcode,
                ApiContants.AMAP_USER_KEY_VALUE,
                ApiContants.AMAP_USER_EXTENSION_VALUE_BASE,
                ApiContants.AMAP_USER_OUTPUT_VALUE)
                .subscribeOn(Schedulers.io());
    }

    /*高德天气：预报天气查询接口*/
    public Observable<WeatherLivesResponseData> forecastWeatherGet(final String adcode) {
        return apiService.weatherGet(adcode,
                ApiContants.AMAP_USER_KEY_VALUE,
                ApiContants.AMAP_USER_EXTENSION_VALUE_ALL,
                ApiContants.AMAP_USER_OUTPUT_VALUE)
                .subscribeOn(Schedulers.io());
    }

    //===================================================================================================
    //for test
    /*高德天气：当前天气查询接口:深圳*/
    private void getShenzhenForecastWeather() {
        DataRequestRepos.getInstance().liveWeatherGet("440300")//深圳:adcode:440300 citycode:0755
                /*.observeOn(AndroidSchedulers.mainThread())*/;
    }
}