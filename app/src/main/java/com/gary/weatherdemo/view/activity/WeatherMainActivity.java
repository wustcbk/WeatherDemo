package com.gary.weatherdemo.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gary.weatherdemo.room.CityForecastDbManager;
import com.gary.weatherdemo.viewmodel.WeatherMainActivityViewModel;
import com.gary.weatherdemo.databinding.WeatherMainActivityBinding;



public class WeatherMainActivity extends AppCompatActivity {
    private WeatherMainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    
    private void init(){
        WeatherMainActivityBinding binding = DataBindingUtil.<WeatherMainActivityBinding>setContentView(this, R.layout.activity_weather_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new WeatherMainActivityViewModel();
        binding.setViewModel(viewModel);
    }

    @Override
    protected void onResume() {
        if (viewModel != null){
            viewModel.requestWeatherByCityName();
        }
        super.onResume();
    }
}
