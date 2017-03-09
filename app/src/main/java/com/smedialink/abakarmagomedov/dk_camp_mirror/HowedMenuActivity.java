package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.os.Bundle;

import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.MinProfilActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;


public class HowedMenuActivity extends BaseActivity {


    @Optional
    @OnClick(R.id.buttonMinProfil)
    void onProfileClick(){
        start(MinProfilActivity.class);
    }

    @Optional
    @OnClick(R.id.buttonSpilOgVind)
    void onSpilClick(){
        start(SpilOgVilActivity.class,"http://ec2-52-11-181-117.us-west-2.compute.amazonaws.com/bingo/index.html");
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


    @Override
    protected void onResume() {
        super.onResume();
        //User user = DataManager.getInstance().getPreferenceManager().getUser();
        //Toast.makeText(this, user.getFirstName(), Toast.LENGTH_SHORT).show();
    }
}
