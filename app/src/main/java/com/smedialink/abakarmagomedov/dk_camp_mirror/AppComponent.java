package com.smedialink.abakarmagomedov.dk_camp_mirror;


import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirst;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.AppModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.InteractorModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    OplevelserComponent plusOplevelserComponent(PresenterModule presenterModule);
}
