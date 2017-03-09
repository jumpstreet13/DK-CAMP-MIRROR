package com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil;


import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LoginInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

public class MinInteractor implements Interactor {

    private final DataManager mDataManager;

    public MinInteractor(DataManager dataManager) {
        mDataManager = dataManager;
    }


    @Override
    public void getUserData(MinInteractor.OnFinishedListener listener) {
        User user = mDataManager.getPreferenceManager().getUser();
        if(user != null) listener.onSuccess(user);
        else listener.onError();
    }
    @Override
    public void deleteUser() {
        mDataManager.getPreferenceManager().setUserNotExist();
    }

    @Override
    public void getInterests(MinInteractor.OnFinishedListener listener) {
        User user = mDataManager.getPreferenceManager().getUser();
        if(user != null){
            listener.onInterestSucces(user.getInterests());
        }
    }

    @Override
    public void getFeriet(MinInteractor.OnFinishedListener listener) {
        mDataManager.getPreferenceManager().getUser().getAccomondations();
        User user = mDataManager.getPreferenceManager().getUser();
        if(user != null){
            listener.onInterestSucces(user.getAccomondations());
        }
    }


}
