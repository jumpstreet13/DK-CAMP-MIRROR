package com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2;


import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;

public class OpleveslerInteractorSecond implements OpleveslerInteractor {

    @Override
    public void fetchView(OpleveslerInteractor.OnFinishedListener listener) {
        Home home = Home.getInstanse();
        if (home != null) {
            listener.onSuccess(home.getFocusedItem());
        } else {
            listener.onError();
        }
    }
}
