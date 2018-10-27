package com.gary.weatherdemo.viewmodel;

import android.databinding.ObservableField;

import com.gary.weatherdemo.view.adapter.WeatherRecyclerAdapter;


public class WeatherMainActivityViewModel {
    public final ObservableField<WeatherRecyclerAdapter> weatherAdapter = new ObservableField<>();
    private final WeatherRecyclerAdapter adapter;

    public WeatherMainActivityViewModel() {
        adapter = new WeatherRecyclerAdapter();
    }

    public void requestWeatherByCityName() {
        /*DataRequestRepos.getInstance().forecastWeatherGet("440300")//深圳:adcode:440300
                *//*.compose(mActivity.<WeatherAllResponseData>bindUntilEvent(ActivityEvent.PAUSE))*//*
                .subscribeOn(Schedulers.io())//设置1：在io子线程执行
                .observeOn(AndroidSchedulers.mainThread()) //设置2：在UI主线程执行回调
                .subscribe(
                        new Action1<WeatherAllResponseData>() { //设置3：回调实现，供rxjava回调时调用UI刷新
                            @Override
                            public void call(WeatherAllResponseData weatherGetResponse) {
                                if (weatherGetResponse.isSuccessful()) {
                                    adapter.setAdapterData(weatherGetResponse);
                                    weatherAdapter.set(adapter);
                                }
                            }
                        });*/
    }
}
