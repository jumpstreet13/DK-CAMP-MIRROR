package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;


public class HowedMenuActivity extends AppCompatActivity {


    @Optional
    @OnClick(R.id.buttonMinProfil)
    void onProfileClick(){MinProfilActivity.start(this);
    }

    @Optional
    @OnClick(R.id.buttonSpilOgVind)
    void onSpilClick(){
        SpilOgVilActivity.goTo(this);
    }

    @Optional
    @OnClick(R.id.buttonCampingId)
    void onCampingClick(){
        DigitaltIdActivity.start(this);
    }

    @Optional
    @OnClick(R.id.buttonTaetPa)
    void onTaetClick() {ProfilActivity.start(this);}

    @Optional
    @OnClick(R.id.buttonFordele)
    void onFordeleClick(){FordeleActivity.start(this);}

    public static void goTo(Context context){
        Intent intent = new Intent(context, HowedMenuActivity.class);
        context.startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howed_menu);
        ButterKnife.bind(this);
    }
}
