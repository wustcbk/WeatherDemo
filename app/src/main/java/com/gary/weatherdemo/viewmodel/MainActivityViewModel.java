package com.gary.weatherdemo.viewmodel;

import android.databinding.ObservableField;

import com.gary.weatherdemo.network.ForecastRequestClient;
import com.gary.weatherdemo.network.response.AllForecastResponseData;
import com.gary.weatherdemo.view.adapter.ForecastRecyclerAdapter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivityViewModel {
    public final ObservableField<ForecastRecyclerAdapter> weatherAdapter = new ObservableField<>();
    private final ForecastRecyclerAdapter adapter;
    // TBD: LiveData
    // private LiveData<AdcodeConfigInfo> cityPageInfo;

    public MainActivityViewModel() {
        adapter = new ForecastRecyclerAdapter();
    }

    public void requestWeatherByCityName() {
        ForecastRequestClient.getInstance().forecastWeatherPost("440300")//深圳:adcode:440300
                .subscribeOn(Schedulers.io())//设置1：在io子线程执行
                .observeOn(AndroidSchedulers.mainThread()) //设置2：在UI主线程执行回调
                .subscribe(new Observer<AllForecastResponseData>() {//设置3：UI主线程回調實現
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AllForecastResponseData responseData) {
                        if (responseData != null && responseData.isSuccessful()) {
                            adapter.setAdapterData(responseData.getWeatherAllResult());
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
