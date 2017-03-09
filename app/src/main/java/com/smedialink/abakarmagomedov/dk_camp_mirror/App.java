package com.smedialink.abakarmagomedov.dk_camp_mirror;


import android.app.Application;

import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.AppModule;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class App extends Application {

    protected static App instance;
    private AppComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mAppComponent = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }


    public static App get() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public static String parseHtml(String parse) {
        Document document = Jsoup.parse(parse);
        return document.text();
    }


}
