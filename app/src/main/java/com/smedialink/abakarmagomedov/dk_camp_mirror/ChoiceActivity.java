package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LogInActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoiceActivity extends BaseActivity {

    @BindView(R.id.toolBarInActivityChoice) Toolbar mToolbar;

    @OnClick(R.id.buttonlogIn)
    void onClick() {
        start(LogInActivity.class);
    }

    @OnClick(R.id.buttontilmelding)
    void onTimedielingClick(){
        start(SignUpActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
    }

}
