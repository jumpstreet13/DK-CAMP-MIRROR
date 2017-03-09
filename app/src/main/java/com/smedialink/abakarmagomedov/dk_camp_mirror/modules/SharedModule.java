package com.smedialink.abakarmagomedov.dk_camp_mirror.modules;


import android.content.Context;
import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.SharedPreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedModule {

    @Provides
    @NonNull
    @Singleton
    SharedPreferenceManager provideSharedPreferenceManager(Context context){
        return  new SharedPreferenceManager(context);
    }

}
