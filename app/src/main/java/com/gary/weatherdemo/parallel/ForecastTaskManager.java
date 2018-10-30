package com.gary.weatherdemo.parallel;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by GaryCao on 2018/10/25.
 */
public class ForecastTaskManager {
    private final String TAG = "ForecastTaskManager";
    private static ForecastTaskManager forecastTaskManager;

    /**
     * 处理耗时流程
     */
    private Handler threadHandler;

    /**
     * 处理UI刷新
     */
    private Handler uiHandler = new Handler();

    public ForecastTaskManager(Context context) {
        Log.i(TAG, "ForecastTaskManager()");
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

    public synchronized static ForecastTaskManager getInstance(Context context) {
        if (forecastTaskManager == null) {
            forecastTaskManager = new ForecastTaskManager(context);
        }
        return forecastTaskManager;
    }
    //===================================================================================================
    //for test

}
