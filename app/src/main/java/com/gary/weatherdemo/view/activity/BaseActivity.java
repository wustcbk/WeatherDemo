package com.gary.weatherdemo.view.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by GaryCao on 2018/10/28.
 */
public class BaseActivity extends Activity {
    /*GoF4:模板方法? ：提供共用流程实现*/
    // private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initAdMob();
    }

    private void initAdMob(){
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        /*MobileAds.initialize(this, Constants.ADMOB_APP_ID);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
    }
}
