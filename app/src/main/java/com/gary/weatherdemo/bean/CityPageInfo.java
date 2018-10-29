package com.gary.weatherdemo.bean;

import java.util.List;

public class CityPageInfo {
    /*默认设置城市adccode*/
    String defAdccode;

    /*天气PageView列表，用于收藏天气地区信息*/
    public final List<CityInfo> CityInfoDataList = null;

    public class CityInfo {
        String adrName;
        String adcCode;
        String cityCode;
    }
}
