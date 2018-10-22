package com.gary.weatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherCurrentResult {
    @SerializedName("province")
    @Expose
    public final String province = null;

    @SerializedName("city")
    @Expose
    public final String city = null;

    @SerializedName("adcode")
    @Expose
    public final String adcode = null;

    @SerializedName("weather")
    @Expose
    public final String weather = null;

    @SerializedName("temperature")
    @Expose
    public final String temperature = null;

    @SerializedName("winddirection")
    @Expose
    public final String winddirection = null;

    @SerializedName("windpower")
    @Expose
    public final String windpower = null;

    @SerializedName("humidity")
    @Expose
    public final String humidity = null;

    @SerializedName("reporttime")
    @Expose
    public final String reporttime = null;
}
