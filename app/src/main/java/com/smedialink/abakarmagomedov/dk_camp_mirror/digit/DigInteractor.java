package com.smedialink.abakarmagomedov.dk_camp_mirror.digit;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

public interface DigInteractor {

    interface OnFinishedListener {
        void onError();
        void onSuccess(User user);
    }

   void getUser(DigInteractor.OnFinishedListener listener);

}
