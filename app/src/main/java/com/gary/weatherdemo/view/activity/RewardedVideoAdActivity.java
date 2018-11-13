package com.gary.weatherdemo.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gary.weatherdemo.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class RewardedVideoAdActivity extends AppCompatActivity {
    private RewardedVideoAd mRewardedVideoAd;
    private RewardedVideoAdListener listener ;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded_video_ad);
        initAdMob();
    }

    private void initAdMob() {
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        listener = new RewardedVideoAdListenerImpl();

        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(listener);
        loadRewardedVideoAd();

        btn = findViewById(R.id.rewarded_video_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }
            }
        });
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd(getString(R.string.admob_rewarded_video_ads_id),
                new AdRequest.Builder().build());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private class RewardedVideoAdListenerImpl implements RewardedVideoAdListener{

        @Override
        public void onRewarded(RewardItem reward) {
            Toast.makeText(getApplicationContext(), "onRewarded! currency: " + reward.getType() + "  amount: " +
                    reward.getAmount(), Toast.LENGTH_SHORT).show();
            // Reward the user.
        }

        @Override
        public void onRewardedVideoAdLeftApplication() {
            Toast.makeText(getApplicationContext(), "onRewardedVideoAdLeftApplication",
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoAdClosed() {
            Toast.makeText(getApplicationContext(), "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();

            // Load the next rewarded video ad.
            // loadRewardedVideoAd();
        }

        @Override
        public void onRewardedVideoAdFailedToLoad(int errorCode) {
            Toast.makeText(getApplicationContext(), "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoAdLoaded() {
            Toast.makeText(getApplicationContext(), "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoAdOpened() {
            Toast.makeText(getApplicationContext(), "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoStarted() {
            Toast.makeText(getApplicationContext(), "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRewardedVideoCompleted() {
            Toast.makeText(getApplicationContext(), "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
        }
    }
}
