package com.gary.weatherdemo.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.gary.weatherdemo.network.DataRequestRepos;
import com.gary.weatherdemo.network.response.WeatherResponseData;
import com.gary.weatherdemo.view.adapter.WeatherRecyclerAdapter;
import com.trello.rxlifecycle.ActivityEvent;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;

public class WeatherMainActivityViewModel {
    public final ObservableField<WeatherRecyclerAdapter> weatherAdapter = new ObservableField<>();
    private final WeatherRecyclerAdapter adapter;

    public WeatherMainActivityViewModel() {
        adapter = new WeatherRecyclerAdapter();
    }

    public void requestWeatherByCityName() {
        DataRequestRepos.getInstance().forecastWeatherGet("440300")//深圳:adcode:440300 citycode:0755
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<WeatherResponseData>() {
                               @Override
                               public void call(WeatherResponseData weatherGetResponse) {
                                   if (weatherGetResponse.isSuccessful()) {
                                       adapter.setAdapterData(weatherGetResponse);
                                       weatherAdapter.set(adapter);
                                   }
                               }
                           });
    }
}
