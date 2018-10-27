package com.gary.weatherdemo.parallel;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;


public class WeatherManager {
    private final String TAG = "WeatherManager";
    private static WeatherManager weatherManager;

    /**
     * 处理耗时流程
     */
    private Handler threadHandler;

    /**
     * 处理UI刷新
     */
    private Handler uiHandler = new Handler();

    public WeatherManager(Context context) {
        Log.i(TAG, "WeatherManager()");
        initWorkHandlerThread();
    }

    private void initWorkHandlerThread() {
        Log.i(TAG, "initWorkHandlerThread");
        HandlerThread handlerThread = new HandlerThread("weather_thread");
        handlerThread.start();

        threadHandler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(android.os.Message msg) {
                //TBD... 处理耗时流程
            }
        };
    }

    public synchronized static WeatherManager getInstance(Context context) {
        if (weatherManager == null) {
            weatherManager = new WeatherManager(context);
        }
        return weatherManager;
    }
    //===================================================================================================
    //for test

}
