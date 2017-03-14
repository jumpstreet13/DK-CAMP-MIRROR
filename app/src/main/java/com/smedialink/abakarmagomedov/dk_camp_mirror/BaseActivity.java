package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;


import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.utils.ConstantManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.utils.IntentUtils;

import java.util.List;

import javax.inject.Inject;

import dagger.Module;


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

    public void start(Class<?> where, int... flag) {
        Intent intent = new Intent(this, where);
        for(int i = 0;i < flag.length; i++){
            intent.setFlags(flag[i]);
        }
        startActivity(intent);
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

    public void startInternet(String url){
        Uri adress = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, adress));
    }


    public void showDialog(List<String> params){
        FragmentManager fm = getFragmentManager();
        CustomDialog customDialog = CustomDialog.newInstance();
        customDialog.setList(params);
        customDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        customDialog.show(fm, "fragment");
    }

    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
    }

    public void openApplicationSettings(){
        Intent appSettingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivityForResult(appSettingsIntent, ConstantManager.PEPMISSION_REQUEST_SETTINGS_CODE);
    }

    public boolean hasGPSConnection() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public boolean validate(DataManager dataManager){
        return dataManager.getPreferenceManager().getUserExist().equals("NO");
    }

}
