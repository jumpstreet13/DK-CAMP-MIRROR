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
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howed_menu);
        mButton = (Button) findViewById(R.id.buttonMinProfil);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HowedMenuActivity.this, FordeleActivity.class);
                startActivity(intent);
            }
        });

    }
}
