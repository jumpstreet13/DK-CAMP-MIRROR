package com.smedialink.abakarmagomedov.dk_camp_mirror;


import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class App extends Application {

    protected static App instance;
    private AppComponent mAppComponent;
    public static SharedPreferences sSharedPreference;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mAppComponent = buildComponent();
        sSharedPreference = PreferenceManager.getDefaultSharedPreferences(this);
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .build();
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

    public static String parseHtml(String parse){
        Document document = Jsoup.parse(parse);
        return document.text();
    }

    public static boolean validate(){
        DataManager dataManager = DataManager.getInstance();
        return dataManager.getPreferenceManager().getUserExist().equals("NO");
    }

}
