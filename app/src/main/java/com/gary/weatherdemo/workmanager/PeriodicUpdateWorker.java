package com.gary.weatherdemo.workmanager;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

/**
 * Created by GaryCao on 2018/11/04.
 */
public class PeriodicUpdateWorker extends Worker {
    private static final String TAG = PeriodicUpdateWorker.class.getSimpleName();

    @NonNull
    @Override
    public Result doWork() {
        try {
            //TBD

            // If there were no errors, return SUCCESS
            return Result.SUCCESS;

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Result.FAILURE;
        } catch (Throwable throwable) {
            // If there were errors, return FAILURE
            Log.e(TAG, "Error increasing day", throwable);
            return Result.FAILURE;
        }
    }
}
