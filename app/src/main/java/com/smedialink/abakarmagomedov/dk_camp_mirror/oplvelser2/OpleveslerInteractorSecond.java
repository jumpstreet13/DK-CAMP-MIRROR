package com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2;


import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;

public class OpleveslerInteractorSecond implements OpleveslerInteractor {

    private final Home mHome;

    public OpleveslerInteractorSecond(Home home) {
        mHome = home;
    }

    @Override
    public void fetchView(OpleveslerInteractor.OnFinishedListener listener) {
        if (mHome != null) {
            listener.onSuccess(mHome.getFocusedItem());
        } else {
            listener.onError();
        }
    }
}
