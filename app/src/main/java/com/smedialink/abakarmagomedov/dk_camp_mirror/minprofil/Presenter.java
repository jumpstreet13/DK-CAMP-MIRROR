package com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil;


import android.content.DialogInterface;

public interface Presenter {

    void fetchData();
    void setUserNotExist();
    void clikced(int id);
    void showExitDialog();
}
