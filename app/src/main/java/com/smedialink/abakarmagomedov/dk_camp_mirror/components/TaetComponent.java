package com.smedialink.abakarmagomedov.dk_camp_mirror.components;

import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.InteractorModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.scopeAnnotation;
import com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa.TaetPa;

import javax.inject.Scope;

import dagger.Subcomponent;

@Subcomponent(modules = {InteractorModule.class, PresenterModule.class})
@scopeAnnotation
public interface TaetComponent {
    void inject(TaetPa taetPa);
}
