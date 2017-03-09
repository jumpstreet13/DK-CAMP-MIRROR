package com.smedialink.abakarmagomedov.dk_camp_mirror.login;


import android.util.Log;
import android.widget.Toast;

import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Credential;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;
import com.smedialink.abakarmagomedov.dk_camp_mirror.network.ApiDkService;
import com.smedialink.abakarmagomedov.dk_camp_mirror.network.ServiceGenerator;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogInteractor implements LoginInteractor {
    private static Retrofit.Builder sBuilder = new Retrofit.Builder().baseUrl(ApiDkService.BASE_URL);
    private final DataManager mDataManager;

    public LogInteractor(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void logIn(final LogInteractor.OnFinishedListener listener) {
        Call<User> call = ServiceGenerator.createService(ApiDkService.class, sBuilder).login(new Credential("hello@lampa.dk", "Gravene01"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("LOL", response.body().getFirstName() + " " + response.body().getSecondName());
                mDataManager.getPreferenceManager().saveUserExist();
                mDataManager.getPreferenceManager().saveUser(response.body());
                listener.onSuccess();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onError();
            }
        });
    }
}
