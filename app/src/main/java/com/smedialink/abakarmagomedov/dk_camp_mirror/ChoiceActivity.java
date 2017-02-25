package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends AppCompatActivity {

   /* @BindView(R.id.buttonlogIn) Button mButton;
    @OnClick(R.id.buttonlogIn)
    void onClick(){
        Intent intent = new Intent(ChoiceActivity.this, LogInActivity.class);
        startActivity(intent);
    }*/


    private Toolbar toolbar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        toolbar = (Toolbar) findViewById(R.id.toolBarInActivityChoice);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        button = (Button) findViewById(R.id.buttonlogIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceActivity.this, LogInActivity.class);
                startActivity(intent);
            }


        });
    }

}
