package com.gary.weatherdemo.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.gary.weatherdemo.R;
import com.gary.weatherdemo.databinding.WeatherMainActivityBinding;
import com.gary.weatherdemo.viewmodel.MainActivityViewModel;

public class ForecastMainActivity extends BaseActivity {
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    private void initViews() {
        WeatherMainActivityBinding binding = DataBindingUtil.<WeatherMainActivityBinding>setContentView(this, R.layout.activity_weather_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new MainActivityViewModel();
        binding.setViewModel(viewModel);
    }

    @Override
    protected void onResume() {
        if (viewModel != null) {
            viewModel.requestWeatherByCityName();
        }
        super.onResume();
    }
}
