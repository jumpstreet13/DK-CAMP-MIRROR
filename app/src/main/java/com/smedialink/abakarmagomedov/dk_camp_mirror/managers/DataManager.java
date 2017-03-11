package com.smedialink.abakarmagomedov.dk_camp_mirror.managers;


public class DataManager {

    //private static DataManager instance = null;
    SharedPreferenceManager mPreferenceManager;

   // private DataManager() {

   // }

 /*   public static DataManager getInstance() {
       *//* if (instance == null) {
            instance = new DataManager();
        }
        return instance;*//*
    }*/

    public DataManager(SharedPreferenceManager manager){
        mPreferenceManager = manager;
    }

    public SharedPreferenceManager getPreferenceManager(){
        return mPreferenceManager;
    }

}
