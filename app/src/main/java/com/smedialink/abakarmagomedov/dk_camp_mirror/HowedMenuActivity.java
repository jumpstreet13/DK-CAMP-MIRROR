package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;


public class HowedMenuActivity extends BaseActivity {


    @Optional
    @OnClick(R.id.buttonMinProfil)
    void onProfileClick(){
        start(this, MinProfilActivity.class);
    }

    @Optional
    @OnClick(R.id.buttonSpilOgVind)
    void onSpilClick(){
        start(SpilOgVilActivity.class);
    }

    @Optional
    @OnClick(R.id.buttonCampingId)
    void onCampingClick(){
        start(DigitaltIdActivity.class);
    }

    @Optional
    @OnClick(R.id.buttonTaetPa)
    void onTaetClick() {
        start(ProfilActivity.class);
    }

    @Optional
    @OnClick(R.id.buttonFordele)
    void onFordeleClick(){start(FordeleActivity.class);}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howed_menu);
        ButterKnife.bind(this);
    }
}
