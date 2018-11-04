package com.gary.weatherdemo.utils;

/**
 * Created by GaryCao on 2018/10/28.
 */
public class AddressAdcodeQueryUtils {
    //GoF4:模板方法，實現高德天气地区+adcode对照表xml文件解析,供本地动态查询使用。
    private static final String TAG = AddressAdcodeQueryUtils.class.getSimpleName();
    private static AddressAdcodeQueryUtils instance = new AddressAdcodeQueryUtils();

    private AddressAdcodeQueryUtils(){
        init();
    }

    private void init(){
    }

    public void LoadAddressAdcodeConfig(){
    }


    public static AddressAdcodeQueryUtils getInstance() {
        return instance ;
    }

}
