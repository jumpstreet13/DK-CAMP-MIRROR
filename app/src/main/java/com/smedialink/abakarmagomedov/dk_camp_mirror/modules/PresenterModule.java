package com.smedialink.abakarmagomedov.dk_camp_mirror.modules;


import android.content.Context;

import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirst;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirstPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserFirstView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    private OplevelserFirstView mOplevelserFirstView;

    public PresenterModule(OplevelserFirstView oplevelserFirstView){
        this.mOplevelserFirstView = oplevelserFirstView;
    }

    @Provides
    OplevelserActivityPresenter provideOplevelserActivityPresenter(OplevelserActivityInteractor oplevelserActivityInteractor){
        return new OplevelserActivityFirstPresenter(mOplevelserFirstView, oplevelserActivityInteractor);
    }

}
