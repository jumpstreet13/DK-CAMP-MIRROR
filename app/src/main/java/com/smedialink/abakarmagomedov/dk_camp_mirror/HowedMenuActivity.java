package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Intent;
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
import butterknife.OnClick;


public class HowedMenuActivity extends AppCompatActivity {

 /*   @BindView(R.id.buttonMinProfil) Button mProfilButton;

    @OnClick(R.id.buttonMinProfil)
    void onClick() {
        Log.d("Butter", "clicked");
        Intent intent = new Intent(HowedMenuActivity.this, FordeleActivity.class);
        startActivity(intent);
    }*/
    private Button mButtonFordele, mButtonOpleve1, mButtonOpleve2, mButtonSpil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howed_menu);
        mButtonFordele = (Button) findViewById(R.id.buttonMinProfil);
        mButtonOpleve1 = (Button) findViewById(R.id.buttonCampingId);
        mButtonOpleve2 = (Button) findViewById(R.id.buttonFordele);
        mButtonSpil = (Button) findViewById(R.id.buttonTaetPa);
        mButtonFordele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HowedMenuActivity.this, FordeleActivity.class);
                startActivity(intent);
            }
        });

        mButtonOpleve1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HowedMenuActivity.this, OplevelserActivityFirst.class);
                startActivity(intent);
            }
        });

        mButtonOpleve2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HowedMenuActivity.this, OpleveslerActivitySecond.class);
                startActivity(intent);
            }
        });

        mButtonSpil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HowedMenuActivity.this, SpilOgVilActivity.class);
                startActivity(intent);
            }
        });

    }
}
