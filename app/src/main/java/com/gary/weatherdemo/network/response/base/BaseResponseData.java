package com.gary.weatherdemo.network.response.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponseData {
    @SerializedName("status")
    @Expose
    private final String status = null;

    @SerializedName("count")
    @Expose
    private final String count = null;

    @SerializedName("info")
    @Expose
    private final String info = null;

    @SerializedName("infocode")
    @Expose
    private final String infocode = null;

    public boolean isSuccessful() {
        return status != null && status.eqauls("1");
    }

    public boolean isInfoValid() {
        return infocode != null && infocode.eqauls("1000");
    }
}
