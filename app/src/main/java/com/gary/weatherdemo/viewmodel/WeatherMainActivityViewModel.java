package com.gary.weatherdemo.viewmodel;

import android.databinding.ObservableField;

import com.gary.weatherdemo.network.DataRequestRepos;
import com.gary.weatherdemo.network.response.WeatherAllResponseData;
import com.gary.weatherdemo.view.adapter.WeatherRecyclerAdapter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class WeatherMainActivityViewModel {
    public final ObservableField<WeatherRecyclerAdapter> weatherAdapter = new ObservableField<>();
    private final WeatherRecyclerAdapter adapter;

    public WeatherMainActivityViewModel() {
        adapter = new WeatherRecyclerAdapter();
    }

    /*GoF2: 观察者模式：注册监听&回调实现*/
    public void requestWeatherByCityName() {
        DataRequestRepos.getInstance().forecastWeatherGet("440300")//深圳:adcode:440300
                .subscribeOn(Schedulers.io())//设置1：在io子线程执行
                .observeOn(AndroidSchedulers.mainThread()) //设置2：在UI主线程执行回调
                .subscribe(new Observer<WeatherAllResponseData>() {//设置3：UI主线程回調實現
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherAllResponseData weatherAllResponseData) {
                        if (weatherAllResponseData.isSuccessful()) {
                            adapter.setAdapterData(weatherAllResponseData);
                            weatherAdapter.set(adapter);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
