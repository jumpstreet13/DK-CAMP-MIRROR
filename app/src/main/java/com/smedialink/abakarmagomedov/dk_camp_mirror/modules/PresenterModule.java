package com.smedialink.abakarmagomedov.dk_camp_mirror.modules;


import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirstPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserFirstView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LogPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LoginInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LoginPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LoginView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerInteractorSecond;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerPresenterSecond;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerView;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    private OplevelserFirstView mOplevelserFirstView;
    private OpleveslerView mOpleveslerView;
    private LoginView mLoginView;

    public PresenterModule(OplevelserFirstView oplevelserFirstView){
        this.mOplevelserFirstView = oplevelserFirstView;
    }

    public PresenterModule(OpleveslerView opleveslerView){
        this.mOpleveslerView = opleveslerView;
    }

    public PresenterModule(LoginView loginView){
        this.mLoginView = loginView;
    }

    @Provides
    OplevelserActivityPresenter provideOplevelserActivityPresenter(OplevelserActivityInteractor oplevelserActivityInteractor){
        return new OplevelserActivityFirstPresenter(mOplevelserFirstView, oplevelserActivityInteractor);
    }

    @Provides
    OpleveslerPresenter provideOpleveslerPresenter(OpleveslerInteractor opleveslerInteractor){
        return new OpleveslerPresenterSecond(mOpleveslerView, opleveslerInteractor);
    }

    @Provides
    LoginPresenter provideLoginAcitvityPresenter(LoginInteractor loginInteractor){
        return new LogPresenter(mLoginView, loginInteractor);
    }

}
