package com.smedialink.abakarmagomedov.dk_camp_mirror.components;


import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LogInActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.Presenter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.DataManagerModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.InteractorModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.SharedModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.scopeAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.Subcomponent;

@Subcomponent (modules = {InteractorModule.class, PresenterModule.class})
@scopeAnnotation
public interface LogInComponent {
    void inject(LogInActivity logInActivity);
}


