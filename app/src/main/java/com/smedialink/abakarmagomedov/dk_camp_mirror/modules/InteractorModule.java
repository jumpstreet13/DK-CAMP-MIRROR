package com.smedialink.abakarmagomedov.dk_camp_mirror.modules;


import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirstInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.digit.DigInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.digit.DigInteractorImp;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LogInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LoginInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.Interactor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.MinInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerInteractorSecond;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    OplevelserActivityInteractor provideOplevelserActivityInteractor(Home home){
        return new OplevelserActivityFirstInteractor(home);
    }

    @Provides
    OpleveslerInteractor provideOpleveslerInteractor(Home home){
        return new OpleveslerInteractorSecond(home);
    }

    @Provides
    LoginInteractor provideLoginInteractor(DataManager dataManager){
        return new LogInteractor(dataManager);
    }

    @Provides
    Interactor provideInteractor(DataManager dataManager){return new MinInteractor(dataManager);}

    @Provides
    DigInteractor provideDigInteractor(DataManager dataManager){return new DigInteractorImp(dataManager);}
}
