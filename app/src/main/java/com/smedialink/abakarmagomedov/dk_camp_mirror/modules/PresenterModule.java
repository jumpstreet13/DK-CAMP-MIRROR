package com.smedialink.abakarmagomedov.dk_camp_mirror.modules;


import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirstPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserFirstView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.digit.DigInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.digit.DigPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.digit.DigPresenterImp;
import com.smedialink.abakarmagomedov.dk_camp_mirror.digit.DigView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LogPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LoginInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LoginPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LoginView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.Interactor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.MinPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.MinProfilView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.Presenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerPresenterSecond;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa.TaetPaInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa.TaetPaPresenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa.TaetPaPresenterImp;
import com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa.TaetPaView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    private OplevelserFirstView mOplevelserFirstView;
    private OpleveslerView mOpleveslerView;
    private LoginView mLoginView;
    private MinProfilView mMinProfilView;
    private DigView mDigView;
    private TaetPaView mTaetPaView;

    public PresenterModule(TaetPaView taetPaView) {
        mTaetPaView = taetPaView;
    }

    public PresenterModule(OplevelserFirstView oplevelserFirstView) {
        this.mOplevelserFirstView = oplevelserFirstView;
    }

    public PresenterModule(OpleveslerView opleveslerView) {
        this.mOpleveslerView = opleveslerView;
    }

    public PresenterModule(LoginView loginView) {
        this.mLoginView = loginView;
    }

    public PresenterModule(MinProfilView minProfilView){
        mMinProfilView = minProfilView;
    }

    public PresenterModule(DigView digView){
        this.mDigView = digView;
    }


    @Provides
    TaetPaPresenter provideTaetPaPresenter(TaetPaInteractor interactor){
        return new TaetPaPresenterImp(mTaetPaView, interactor);
    }

    @Provides
    OplevelserActivityPresenter provideOplevelserActivityPresenter(OplevelserActivityInteractor oplevelserActivityInteractor) {
        return new OplevelserActivityFirstPresenter(mOplevelserFirstView, oplevelserActivityInteractor);
    }

    @Provides
    OpleveslerPresenter provideOpleveslerPresenter(OpleveslerInteractor opleveslerInteractor) {
        return new OpleveslerPresenterSecond(mOpleveslerView, opleveslerInteractor);
    }

    @Provides
    LoginPresenter provideLoginAcitvityPresenter(LoginInteractor loginInteractor) {
        return new LogPresenter(mLoginView, loginInteractor);
    }

    @Provides
    Presenter provideMinPresenter(Interactor interactor){
        return new MinPresenter(mMinProfilView, interactor);
    }

    @Provides
    DigPresenter provideDigPresenter(DigInteractor digInteractor){
        return  new DigPresenterImp(mDigView, digInteractor);
    }


}
