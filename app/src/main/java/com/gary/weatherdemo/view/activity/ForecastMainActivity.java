package com.gary.weatherdemo.view.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.gary.weatherdemo.R;
import com.gary.weatherdemo.databinding.WeatherMainActivityBinding;
import com.gary.weatherdemo.viewmodel.MainActivityViewModel;

public class ForecastMainActivity extends Activity {
    private MainActivityViewModel viewModel;
    // private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        // initAdMob();
    }

    private void initViews() {
        WeatherMainActivityBinding binding = DataBindingUtil.<WeatherMainActivityBinding>setContentView(this, R.layout.activity_weather_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new MainActivityViewModel();
        binding.setViewModel(viewModel);
    }

    private void initAdMob(){
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        /*MobileAds.initialize(this, Constants.ADMOB_APP_ID);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
    }

    @Override
    protected void onResume() {
        if (viewModel != null) {
            viewModel.requestWeatherByCityName();
        }
        super.onResume();
    }
}
