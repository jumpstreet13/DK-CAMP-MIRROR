package com.smedialink.abakarmagomedov.dk_camp_mirror.managers;


import android.content.SharedPreferences;

import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.utils.ConstantManager;

public class SharedPreferenceManager {

    private SharedPreferences mSharedPreference;

    public SharedPreferenceManager() {
        mSharedPreference = App.getSharedPreference();
    }

    public void saveAccesToken(String token){
        SharedPreferences.Editor editor = mSharedPreference.edit();
        editor.putString(ConstantManager.X_ACCESS_TOKEN, token);
        editor.apply();
    }

    public String getAccesToken(){
        return mSharedPreference.getString(ConstantManager.X_ACCESS_TOKEN, null);
    }

}
