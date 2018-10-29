package com.gary.weatherdemo.view.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.gary.weatherdemo.R;
import com.gary.weatherdemo.base.Contants;
import com.gary.weatherdemo.databinding.WeatherMainActivityBinding;
import com.gary.weatherdemo.viewmodel.WeatherMainActivityViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class WeatherMainActivity extends Activity {
    private WeatherMainActivityViewModel viewModel;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        // initAdMob();
    }

    private void initViews() {
        WeatherMainActivityBinding binding = DataBindingUtil.<WeatherMainActivityBinding>setContentView(this, R.layout.activity_weather_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new WeatherMainActivityViewModel();
        binding.setViewModel(viewModel);
    }

    private void initAdMob(){
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, Contants.ADMOB_APP_ID);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    protected void onResume() {
        if (viewModel != null) {
            viewModel.requestWeatherByCityName();
        }
        super.onResume();
    }
}
