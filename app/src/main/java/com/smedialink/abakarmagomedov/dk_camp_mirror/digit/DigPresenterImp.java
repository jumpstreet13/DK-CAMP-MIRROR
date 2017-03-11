package com.smedialink.abakarmagomedov.dk_camp_mirror.digit;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

import java.lang.ref.WeakReference;

public class DigPresenterImp implements DigPresenter, DigInteractor.OnFinishedListener {

    private final WeakReference<DigView> digView;
    private DigInteractor digInteractor;

    public DigPresenterImp(DigView digView, DigInteractor digInteractor) {
        this.digView = new WeakReference<>(digView);
        this.digInteractor = digInteractor;
    }

    @Override
    public void fetchData() {
        digInteractor.getUser(this);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(User user) {
        DigView digView = this.digView.get();
        if(digView != null){
            digView.show(user);
        }
    }
}
