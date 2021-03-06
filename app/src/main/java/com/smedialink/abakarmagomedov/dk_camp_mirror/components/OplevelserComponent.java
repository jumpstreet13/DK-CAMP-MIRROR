package com.smedialink.abakarmagomedov.dk_camp_mirror.components;

import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirst;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LogInActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.MinProfilActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.DataManagerModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.InteractorModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.SharedModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.scopeAnnotation;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerActivitySecond;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Subcomponent;


@Subcomponent(modules = {InteractorModule.class, PresenterModule.class})
@scopeAnnotation
public interface OplevelserComponent {
    void inject(OplevelserActivityFirst oplevelserActivityFirst);
}

