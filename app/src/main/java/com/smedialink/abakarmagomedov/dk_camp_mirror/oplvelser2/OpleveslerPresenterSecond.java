package com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2;



import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.lang.ref.WeakReference;

public class OpleveslerPresenterSecond implements OpleveslerPresenter, OpleveslerInteractor.OnFinishedListener {


    private final WeakReference<OpleveslerView> view;
    private OpleveslerInteractor oplevelserActivityInteractor;

    public OpleveslerPresenterSecond(OpleveslerView view, OpleveslerInteractor oplevelserActivityInteractor) {
        this.view = new WeakReference<OpleveslerView>(view);
        this.oplevelserActivityInteractor = oplevelserActivityInteractor;
    }


    @Override
    public void fetchData() {
        oplevelserActivityInteractor.fetchView(this);
    }

    @Override
    public void start() {
        OpleveslerView view = this.view.get();
        if(view != null){
            view.start();
        }
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(Discount item) {
        OpleveslerView view = this.view.get();
        if(view != null){
            view.setViews(item);
        }
    }
}
