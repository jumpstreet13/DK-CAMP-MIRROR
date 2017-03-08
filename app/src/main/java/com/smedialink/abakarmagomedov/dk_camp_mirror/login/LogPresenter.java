package com.smedialink.abakarmagomedov.dk_camp_mirror.login;


import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

import java.lang.ref.WeakReference;

public class LogPresenter implements LoginPresenter, LoginInteractor.OnFinishedListener {

    private final WeakReference<LoginView> mLoginView;
    private LoginInteractor mLoginInteractor;

    public LogPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        mLoginView = new WeakReference<LoginView>(loginView);
        mLoginInteractor = loginInteractor;
    }

    @Override
    public void click(int id) {
        switch (id){
            case R.id.buttonlogInActivityLogiN:
                LoginView view = mLoginView.get();
                if(view!=null){
                    view.sProgress();
                }
                mLoginInteractor.logIn(this);
        }

    }

    @Override
    public void onError() {
        LoginView view = mLoginView.get();
        if(view!=null){
            view.error();
            view.hProgress();
        }
    }

    @Override
    public void onSuccess() {
        LoginView view = mLoginView.get();
        if(view!=null){
            view.success();
            view.hProgress();
        }

    }
}
