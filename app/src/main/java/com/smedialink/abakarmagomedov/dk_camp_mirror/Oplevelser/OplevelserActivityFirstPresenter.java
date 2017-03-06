package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerAdapter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class OplevelserActivityFirstPresenter implements OplevelserActivityPresenter, OplevelserActivityInteractor.OnFinishedListener {

    private final WeakReference<OplevelserFirstView> oplevelserFirstView;
    private final OplevelserActivityInteractor oplevelserActivityInteractor;

    @Inject
    public OplevelserActivityFirstPresenter(OplevelserFirstView oplevelserFirstView, OplevelserActivityInteractor interactor) {
        this.oplevelserFirstView = new WeakReference<>(oplevelserFirstView);
        this.oplevelserActivityInteractor = interactor;
    }

    @Override
    public void invoke() {
        OplevelserFirstView view = oplevelserFirstView.get();
        if (view != null) {
            view.start();
        }
    }

    @Override
    public void fetchData() {
        OplevelserFirstView view = oplevelserFirstView.get();
        if(view != null) {
            Home home = Home.getInstanse();
            home.setItems(oplevelserActivityInteractor.getFakeData(this));
            view.show(home.getItems());
        }

    }

    @Override
    public void onError() {
        OplevelserFirstView view = oplevelserFirstView.get();
        if(view != null){
            view.success();
        }
    }

    @Override
    public void onSuccess() {
        OplevelserFirstView view = oplevelserFirstView.get();
        if(view != null){
            view.error();
        }

    }
}
