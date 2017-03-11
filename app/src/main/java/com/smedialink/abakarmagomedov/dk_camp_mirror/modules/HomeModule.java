package com.smedialink.abakarmagomedov.dk_camp_mirror.modules;


import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    @NonNull
    @Singleton
    Home provideHome(){
        return new Home();
    }

}
