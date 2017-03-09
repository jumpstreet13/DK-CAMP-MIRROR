package com.smedialink.abakarmagomedov.dk_camp_mirror.managers;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;
import com.smedialink.abakarmagomedov.dk_camp_mirror.utils.ConstantManager;

import javax.inject.Inject;

public class SharedPreferenceManager {

    private SharedPreferences mSharedPreference;
    private Gson mGson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();

    public SharedPreferenceManager(Context context) {
        mSharedPreference = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveUserExist() {
        SharedPreferences.Editor editor = mSharedPreference.edit();
        editor.putString(ConstantManager.IS_HERE, "YES");
        Log.d("EXIST", "USER EXIST NOW");
        editor.apply();
    }

    public void setUserNotExist(){
        SharedPreferences.Editor editor = mSharedPreference.edit();
        editor.putString(ConstantManager.IS_HERE, "NO");
        Log.d("EXIST", "USER EXIST NOW");
        editor.apply();
    }

    public void saveUser(User user) {
        SharedPreferences.Editor editor = mSharedPreference.edit();
        String json = mGson.toJson(user);
        editor.putString(ConstantManager.USER, json);
        editor.apply();
    }

    public User getUser() {
        String json = mSharedPreference.getString(ConstantManager.USER, null);
        return mGson.fromJson(json, User.class);
    }

    public String getUserExist() {
        return mSharedPreference.getString(ConstantManager.IS_HERE, "NO");
    }

}
