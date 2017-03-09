package com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

import java.util.List;

public interface Interactor {
    interface OnFinishedListener {
        void onError();
        void onSuccess(User user);
        void onInterestSucces(List<String> list);
        void onInterestError(List<String> list);
        void onFerietSucces(List<String> list);
        void onFerietError(List<String> list);
    }

    void getUserData(MinInteractor.OnFinishedListener listener);
    void deleteUser();
    void getInterests(MinInteractor.OnFinishedListener listener);
    void getFeriet(MinInteractor.OnFinishedListener listener);
}
