package com.gary.weatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WeatherAllResult {
    @SerializedName("city")
    @Expose
    public final String city = null;

    @SerializedName("adcode")
    @Expose
    public final String adcode = null;

    @SerializedName("province")
    @Expose
    public final String province = null;

    @SerializedName("reporttime")
    @Expose
    public final String reporttime = null;

    @SerializedName("casts")
    @Expose
    public final List<WeatherForecastData> weatherForecastDataList = null;
}
