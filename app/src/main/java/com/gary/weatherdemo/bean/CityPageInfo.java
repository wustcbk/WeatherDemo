package com.gary.weatherdemo.bean;

import java.util.List;

/**
 * Created by GaryCao on 2018/10/28.
 */
public class CityPageInfo {
    /*当前页index*/
    public int curPageIndex;

    /*天气PageView列表，用于收藏天气地区信息*/
    public List<CityInfo> cityInfoList = null;

    public int getCurPageIndex() {
        return curPageIndex;
    }

    public void setCurPageIndex(int index) {
        curPageIndex = index;
    }

    public class CityInfo {
        String adrName;
        String adcCode;
        String cityCode;
    }
}
