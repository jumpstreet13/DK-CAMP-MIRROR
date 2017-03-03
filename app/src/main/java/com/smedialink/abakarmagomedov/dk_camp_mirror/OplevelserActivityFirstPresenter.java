package com.smedialink.abakarmagomedov.dk_camp_mirror;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.lang.ref.WeakReference;
import java.util.List;

public class OplevelserActivityFirstPresenter implements OplevelserActivityPresenter {

    private final WeakReference<OplevelserFirstView> oplevelserFirstView;
    private final OplevelserActivityInteractor oplevelserActivityInteractor;


    public OplevelserActivityFirstPresenter(OplevelserFirstView oplevelserFirstView, OplevelserActivityInteractor interactor) {
        this.oplevelserFirstView = new WeakReference<>(oplevelserFirstView);
        this.oplevelserActivityInteractor = interactor;
    }

    public void invoke(){
        OplevelserFirstView view = oplevelserFirstView.get();
        if (view != null) {
            view.start();
        }
    }

    public List<OpleveslerItem> getFakeData(){
        return oplevelserActivityInteractor.getFakeData();
    }

}
