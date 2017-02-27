package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;


public class HowedMenuActivity extends AppCompatActivity {


    @Optional
    @OnClick(R.id.buttonMinProfil)
    void onProfileClick(){
        FordeleActivity.goTo(this);
    }

    @Optional
    @OnClick(R.id.buttonSpilOgVind)
    void onSpilClick(){
        SpilOgVilActivity.goTo(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howed_menu);
        ButterKnife.bind(this);
    }
}
