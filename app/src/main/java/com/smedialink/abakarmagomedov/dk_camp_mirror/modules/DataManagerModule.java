package com.smedialink.abakarmagomedov.dk_camp_mirror.modules;


import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.SharedPreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataManagerModule {

    @Provides
    @NonNull
    @Singleton
    DataManager provideDataManager(SharedPreferenceManager sh){
        return new DataManager(sh);
    }
}
