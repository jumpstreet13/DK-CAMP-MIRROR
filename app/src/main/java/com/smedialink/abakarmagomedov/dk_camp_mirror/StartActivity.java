package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonStartInActivityStart)
    void onButtonClick(){
        start(ChoiceActivity.class);
    }

    @OnClick(R.id.text_fordele)
    void onTextClick(){
        start(SignUpActivity.class);
    }

}
