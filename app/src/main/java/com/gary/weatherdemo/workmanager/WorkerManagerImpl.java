package com.gary.weatherdemo.workmanager;

import com.gary.weatherdemo.base.Constants;
import com.gary.weatherdemo.utils.ForecastConfigs;

import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

/**
 * Created by GaryCao on 2018/11/04.
 */
public class WorkerManagerImpl implements IWorkerManager {

    @Override
    public void loadAdrAdcodeConfig() {
        // 单次任务：OneTimeWorkRequest
        /*OneTimeWorkRequest workRequest =
                new OneTimeWorkRequest.Builder(LoadAdcodeConfigWorker.class)
                        .setConstraints(myConstraints)
                        .build();*/
        OneTimeWorkRequest.Builder loadConfigRequestBuilder =
                new OneTimeWorkRequest.Builder(LoadAdcodeConfigWorker.class);

        // 设置任务约束
        Constraints myConstraints = new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build();

        loadConfigRequestBuilder.setConstraints(myConstraints);
        loadConfigRequestBuilder.addTag(Constants.LOAD_ADCODES_CONFIG_WORK_NAME);

        OneTimeWorkRequest loadConfigWorkRequest = loadConfigRequestBuilder.build();
        WorkManager.getInstance().enqueue(loadConfigWorkRequest);
    }

    @Override
    public void periodicQueryWeather(){
        // 定时任务：PeriodicWorkRequest
        PeriodicWorkRequest.Builder timerQueryRequestBuilder =
                new PeriodicWorkRequest.Builder(
                        PeriodicUpdateWorker.class,
                        ForecastConfigs.getInstance().getUpdatePeriodicHourCount(),
                        TimeUnit.HOURS,
                        5,
                        TimeUnit.MINUTES);

        Constraints myConstraints = new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build();
        timerQueryRequestBuilder.setConstraints(myConstraints);
        timerQueryRequestBuilder.addTag(Constants.HOUR_INCREMENT_WORK_NAME);

        PeriodicWorkRequest timerWorkRequest = timerQueryRequestBuilder.build();
        WorkManager.getInstance().enqueue(timerWorkRequest);
    }


    @Override
    public void queryCityWeather() {
        // 分步任务
        // 设置任务约束
        Constraints myConstraints = new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build();

        // 任务分步1：查询当前天气
        OneTimeWorkRequest step1RequestBuilder =
                new OneTimeWorkRequest.Builder(QueryCurrentWeatherWorker.class)
                .setConstraints(myConstraints)
                .addTag(Constants.QUERY_CURRENT_WEATHER_WORK_NAME)
                .build();

        // 任务分步2：查询天气预报
        OneTimeWorkRequest step2RequestBuilder =
                new OneTimeWorkRequest.Builder(QueryForecastWorker.class)
                        .setConstraints(myConstraints)
                        .addTag(Constants.QUERY_FORECAST_WORK_NAME)
                        .build();

        //执行分发任务
        WorkManager.getInstance()
                .beginWith(step1RequestBuilder) //work firstly
                .then(step2RequestBuilder) //work secondly
                .enqueue();
    }
}
