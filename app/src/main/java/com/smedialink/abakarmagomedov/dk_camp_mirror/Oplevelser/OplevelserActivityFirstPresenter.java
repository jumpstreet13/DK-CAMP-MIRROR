package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;


import android.support.annotation.NonNull;

import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.lang.ref.WeakReference;
import java.util.List;

public class OplevelserActivityFirstPresenter implements OplevelserActivityPresenter, OplevelserActivityInteractor.OnFinishedListener {

    private final WeakReference<OplevelserFirstView> oplevelserFirstView;
    private OplevelserActivityInteractor oplevelserActivityInteractor;

    public OplevelserActivityFirstPresenter(OplevelserFirstView oplevelserFirstView, OplevelserActivityInteractor interactor) {
        this.oplevelserFirstView = new WeakReference<>(oplevelserFirstView);
        this.oplevelserActivityInteractor = interactor;
    }

    @Override
    public void invoke(Discount item) {
        OplevelserFirstView view = oplevelserFirstView.get();
        if (view != null) {
            oplevelserActivityInteractor.setFocused(item);
            view.start();
        }
    }

    @Override
    public void fetchData() {
        OplevelserFirstView view = oplevelserFirstView.get();
        if (view != null) {
            view.sProgress();
        }
        oplevelserActivityInteractor.fetchOplevelsers(this);
    }

    @Override
    public void refreshData() {
        oplevelserActivityInteractor.fetchOplevelsers(this);
    }

    @Override
    public void onError() {
        OplevelserFirstView view = oplevelserFirstView.get();
        if (view != null) {
            view.error();
            view.hProgress();
        }
    }

    @Override
    public void onSuccess(@NonNull List<Discount> data) {
        OplevelserFirstView view = oplevelserFirstView.get();
        if (view != null) {
            view.show(data);
            view.hProgress();
        }
    }

    // TODO: 13.03.17 Отступы у Pixel C
}
