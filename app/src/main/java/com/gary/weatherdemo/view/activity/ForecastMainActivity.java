package com.gary.weatherdemo.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.commonui.ActionBar;
import com.example.commonui.IActionBarOnClickListener;
import com.gary.weatherdemo.R;
import com.gary.weatherdemo.databinding.WeatherMainActivityBinding;
import com.gary.weatherdemo.utils.LogUtils;
import com.gary.weatherdemo.viewmodel.MainActivityViewModel;

public class ForecastMainActivity extends BaseActivity implements IActionBarOnClickListener {
    private MainActivityViewModel viewModel;
    private ActionBar actionBar;

    @Override
    public void onCreateNew(Bundle savedInstanceState) {
        initViews();
    }

    private void initViews() {
        WeatherMainActivityBinding binding = DataBindingUtil.<WeatherMainActivityBinding>setContentView(this, R.layout.activity_weather_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new MainActivityViewModel();
        binding.setViewModel(viewModel);

        initActionBar();
    }

    @Override
    protected void onResume() {
        if (viewModel != null) {
            viewModel.requestWeatherByCityName();
        }
        super.onResume();
    }

    private void initActionBar() {
        actionBar = (ActionBar) findViewById(R.id.action_bar);
        actionBar.setOnClickListener(this);
    }

    @Override
    public void leftActBarItemClicked() {
        LogUtils.d("rightActBarItemClicked()");
    }

    @Override
    public void rightActBarItemClicked() {
        LogUtils.d("rightActBarItemClicked()");
    }
}
