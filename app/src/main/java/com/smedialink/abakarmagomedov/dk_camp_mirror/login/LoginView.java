package com.smedialink.abakarmagomedov.dk_camp_mirror.login;


import android.widget.Adapter;

import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

public interface LoginView {

    void sProgress();
    void hProgress();
    void error();
    void success();
    void forgetPassword();
}
