package com.smedialink.abakarmagomedov.dk_camp_mirror.modules;


import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirstInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    OplevelserActivityInteractor provideOplevelserActivityInteractor(){
        return new OplevelserActivityFirstInteractor();
    }
}
