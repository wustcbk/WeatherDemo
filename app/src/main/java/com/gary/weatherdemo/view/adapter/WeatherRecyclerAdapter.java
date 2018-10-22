package com.gary.weatherdemo.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.gary.weatherdemo.model.WeatherAllResult;
import com.gary.weatherdemo.model.WeatherForecastData;
import com.gary.weatherdemo.network.response.WeatherResponseData;
import com.gary.weatherdemo.viewmodel.WeatherForecastDayViewModel;

import java.util.ArrayList;

public class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.WeatherForecastDayViewHolder> {
    private ArrayList<WeatherForecastData> weatherUIDataArrayList = new ArrayList<>();

    public WeatherRecyclerAdapter() {
    }

    public void setAdapterData(WeatherResponseData weatherGetResponse) {
        if(null == weatherGetResponse ){
            return;
        }
        weatherUIDataArrayList.clear();
        WeatherAllResult weatherAllResult = weatherGetResponse.getWeatherAllResult();
        if (weatherAllResult != null ) {
            weatherUIDataArrayList =  (ArrayList<WeatherForecastData>) weatherAllResult.weatherForecastDataList;
        }
        notifyDataSetChanged();
    }

    @Override
    public WeatherForecastDayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather_forecast_day, parent, false);
        return new WeatherForecastDayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherForecastDayViewHolder holder, int position) {
        holder.bind(weatherUIDataArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherUIDataArrayList.size();
    }

    public class WeatherForecastDayViewHolder extends RecyclerView.ViewHolder<WeatherForecastData> {
        private final WeatherForecastDayBinding binding;

        public WeatherForecastDayViewHolder(View itemView) {
            super(itemView);
            binding = WeatherForecastDayBinding.bind(itemView);
        }

        public void bind(@NonNull WeatherForecastData data) {
            binding.setViewModel(new WeatherForecastDayViewModel(data));
        }
    }
}
