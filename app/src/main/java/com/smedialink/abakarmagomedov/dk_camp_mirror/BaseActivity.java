package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smedialink.abakarmagomedov.dk_camp_mirror.utils.IntentUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class BaseActivity extends AppCompatActivity {

    protected ProgressDialog mProgressDialog;

    public void start(Class<?> where) {
        Intent intent = new Intent(this, where);
        startActivity(intent);
    }

    public void start(Class<?> where, @Nullable String arg) {
        Intent intent = new Intent(this, where);
        intent.putExtra(IntentUtils.WEB, arg);
        startActivity(intent);
    }

    public void start(Class<?> where, @Nullable String... arg){
        Intent intent = new Intent(this, where);
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

    public void showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.style.ProgressBarStyle);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        } else {
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        }

    }

    public void hideProgress() {
        if(mProgressDialog != null){
            if(mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }
        }
    }

}
