package com.smedialink.abakarmagomedov.dk_camp_mirror.digit;


import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

public class DigInteractorImp implements DigInteractor {
    private final DataManager mDataManager;

    public DigInteractorImp(DataManager dataManager) {
        mDataManager = dataManager;
    }


    @Override
    public void getUser(OnFinishedListener listener) {
        User user = mDataManager.getPreferenceManager().getUser();
        if(user != null) listener.onSuccess(user);
        else listener.onError();
    }
}
