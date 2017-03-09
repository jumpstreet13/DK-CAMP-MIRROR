package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

    @Inject DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        App.get().getAppComponent().inject(this);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (validate(mDataManager)) {
                    start(HowedMenuActivity.class);
                } else {
                    start(StartActivity.class);
                }
            }
        }, 1000);
    }
}
