package com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa;


import com.smedialink.abakarmagomedov.dk_camp_mirror.digit.DigInteractor;

public interface TaetPaInteractor {

    public interface onFinishedListener{
        void onSuccess();
        void onError();
    }

    void checkPermissions(TaetPaInteractor.onFinishedListener listener);
}
