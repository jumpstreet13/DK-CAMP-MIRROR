package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class BaseActivity extends AppCompatActivity {

    public void start(Class<?> where) {
        Intent intent = new Intent(this, where);
        startActivity(intent);
    }

    public void start(Class<?> where, @Nullable String arg) {
        Intent intent = new Intent(this, where);
        intent.putExtra(IntentUtils.WEB, arg);
        startActivity(intent);
    }

    public void start(Class<?> where, @Nullable Bundle flag) {
        Intent intent = new Intent(this, where);
        startActivity(intent, flag);
    }

    public void setToolbar(Toolbar mToolbar) {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void showProgress(){

    }

    public void hideProgress(){

    }
}
