package com.smedialink.abakarmagomedov.dk_camp_mirror.managers;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.smedialink.abakarmagomedov.dk_camp_mirror.DigitaltIdActivity;

public class DataManager {

    private static DataManager instance = null;
    private SharedPreferenceManager mPreferenceManager;

    private DataManager() {
        mPreferenceManager = new SharedPreferenceManager();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public SharedPreferenceManager getPreferenceManager(){
        return mPreferenceManager;
    }


}
