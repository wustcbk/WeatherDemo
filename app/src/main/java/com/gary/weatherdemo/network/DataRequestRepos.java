package com.gary.weatherdemo.network;

import com.gary.weatherdemo.network.response.WeatherResponseData;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import rx.android.schedulers.AndroidSchedulers;

public class DataRequestRepos {
    private static DataRequestRepos dataRequestRepos;

    public synchronized static DataRequestRepos getInstance() {
        if (dataRequestRepos == null) {
            dataRequestRepos = new DataRequestRepos();
        }
        return dataRequestRepos;
    }

    /*高德天气：当前天气查询接口*/
    public Observable<WeatherResponseData> liveWeatherGet(final String adcode) {
        return RetrofitManager.getInstance().getApiClient()
                .weatherGet(adcode,
                        ApiContants.AMAP_USER_KEY_VALUE,
                        ApiContants.AMAP_USER_EXTENSION_VALUE_BASE,
                        ApiContants.AMAP_USER_OUTPUT_VALUE)
                .subscribeOn(Schedulers.io());
    }

    /*高德天气：预报天气查询接口*/
    public Observable<WeatherResponseData> forecastWeatherGet(final String adcode) {
        return RetrofitManager.getInstance().getApiClient()
                .weatherGet(adcode,
                        ApiContants.AMAP_USER_KEY_VALUE,
                        ApiContants.AMAP_USER_EXTENSION_VALUE_ALL,
                        ApiContants.AMAP_USER_OUTPUT_VALUE)
                .subscribeOn(Schedulers.io());
    }

    //===================================================================================================
    //for test
    /*高德天气：当前天气查询接口:深圳*/
    private void getShenzhenForecastWeather(){
        DataRequestRepos.getInstance().liveWeatherGet("440300")//深圳:adcode:440300 citycode:0755
                .observeOn(AndroidSchedulers.mainThread());
    }
}