package com.smedialink.abakarmagomedov.dk_camp_mirror;


import com.smedialink.abakarmagomedov.dk_camp_mirror.components.DigComponent;
import com.smedialink.abakarmagomedov.dk_camp_mirror.components.LogInComponent;
import com.smedialink.abakarmagomedov.dk_camp_mirror.components.MinProfilComponent;
import com.smedialink.abakarmagomedov.dk_camp_mirror.components.OplevelserComponent;
import com.smedialink.abakarmagomedov.dk_camp_mirror.components.OplevelserComponent2;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.Presenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.AppModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.DataManagerModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.HomeModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.SharedModule;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {AppModule.class,DataManagerModule.class,SharedModule.class, HomeModule.class})
@Singleton
public interface AppComponent {
    OplevelserComponent plusOplevelserComponent(PresenterModule presenterModule);
    LogInComponent plusLoginComponent(PresenterModule presenterModule);
    MinProfilComponent plusMinProfilComponent(PresenterModule presenterModule);
    OplevelserComponent2 plusOplevelserComponent2(PresenterModule presenterModule);
    DigComponent plusDigComponent(PresenterModule presenterModule);
    void inject(SplashActivity splashActivity);
}
