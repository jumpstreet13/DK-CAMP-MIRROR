package com.smedialink.abakarmagomedov.dk_camp_mirror;


import com.smedialink.abakarmagomedov.dk_camp_mirror.components.OplevelserComponent;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.AppModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    OplevelserComponent plusComponent(PresenterModule presenterModule);
}
