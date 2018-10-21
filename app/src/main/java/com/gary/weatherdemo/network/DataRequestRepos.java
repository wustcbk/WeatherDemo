package com.gary.weatherdemo.network;

import com.gary.weatherdemo.network.response.WeatherResponseData;

public class DataRequestRepos {
    private static DataRequestRepos dataRequestRepos;

    public synchronized static DataRequestRepos getInstance() {
        if (dataRequestRepos == null) {
            dataRequestRepos = new DataRequestRepos();
        }
        return dataRequestRepos;
    }

    /*高德天气：当前天气查询接口*/
    public Observable<WeatherResponseData> liveWeatherGet(final String city) {
        return RetrofitManager.getInstance().getApiClient()
                .weatherGet(city,
                        ApiContants.AMAP_USER_KEY_VALUE,
                        ApiContants.AMAP_USER_EXTENSION_VALUE_BASE,
                        ApiContants.AMAP_USER_OUTPUT_VALUE)
                .subscribeOn(Schedulers.io());
    }

    /*高德天气：预报天气查询接口*/
    public Observable<WeatherResponseData> forecastWeatherGet(final String city) {
        return RetrofitManager.getInstance().getApiClient()
                .weatherGet(city,
                        ApiContants.AMAP_USER_KEY_VALUE,
                        ApiContants.AMAP_USER_EXTENSION_VALUE_ALL,
                        ApiContants.AMAP_USER_OUTPUT_VALUE)
                .subscribeOn(Schedulers.io());
    }
}