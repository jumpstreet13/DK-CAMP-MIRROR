package com.smedialink.abakarmagomedov.dk_camp_mirror.login;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

public interface LoginInteractor {

    interface OnFinishedListener {
        void onError();
        void onSuccess();
    }

    void logIn(LogInteractor.OnFinishedListener listener);
}
