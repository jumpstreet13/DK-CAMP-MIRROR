package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogInActivity extends BaseActivity {

    @BindView(R.id.toolBarInActivityLog) Toolbar mToolbar;

    @OnClick(R.id.buttonlogInActivityLogiN)
    void onButtonClick() {
        start(HowedMenuActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
    }
}
