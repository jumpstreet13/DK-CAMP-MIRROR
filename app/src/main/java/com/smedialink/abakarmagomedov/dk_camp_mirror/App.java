package com.smedialink.abakarmagomedov.dk_camp_mirror;


import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirst;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.AppModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.InteractorModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;


public class App extends Application {

    protected static App instance;
    private AppComponent mAppComponent;
    private OplevelserComponent mOplevelserComponent;
    public static SharedPreferences sSharedPreference;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sSharedPreference = PreferenceManager.getDefaultSharedPreferences(this);
        mAppComponent = DaggerAppComponent.builder().build();
    }


    public static App get(){
        return  instance;
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public static SharedPreferences getSharedPreference(){
        return sSharedPreference;
    }

}
