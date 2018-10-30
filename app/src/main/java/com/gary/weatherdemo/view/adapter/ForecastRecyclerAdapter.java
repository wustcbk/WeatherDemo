package com.gary.weatherdemo.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gary.weatherdemo.R;
import com.gary.weatherdemo.databinding.WeatherForecastDayBinding;
import com.gary.weatherdemo.model.AllForecastResult;
import com.gary.weatherdemo.model.DayForecastData;
import com.gary.weatherdemo.viewmodel.ForecastDayViewModel;

import java.util.ArrayList;

public class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastRecyclerAdapter.WeatherForecastDayViewHolder> {
    private ArrayList<DayForecastData> weatherUIDataArrayList = new ArrayList<>();

    public ForecastRecyclerAdapter() {
    }

    public void setAdapterData(AllForecastResult allForecastResult) {
        if (null == allForecastResult) {
            return;
        }
        weatherUIDataArrayList.clear();
        weatherUIDataArrayList = (ArrayList<DayForecastData>) allForecastResult.dayForecastDataList;
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

    public class WeatherForecastDayViewHolder extends RecyclerView.ViewHolder {
        private final WeatherForecastDayBinding binding;

        public WeatherForecastDayViewHolder(View itemView) {
            super(itemView);
            binding = WeatherForecastDayBinding.bind(itemView);
        }

        public void bind(@NonNull DayForecastData data) {
            binding.setViewModel(new ForecastDayViewModel(data));
        }
    }
}
