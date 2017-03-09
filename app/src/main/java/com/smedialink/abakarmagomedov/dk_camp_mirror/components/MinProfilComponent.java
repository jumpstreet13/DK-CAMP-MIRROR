package com.smedialink.abakarmagomedov.dk_camp_mirror.components;



import com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil.MinProfilActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.InteractorModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.scopeAnnotation;


import dagger.Subcomponent;

@Subcomponent(modules={InteractorModule.class, PresenterModule.class})
@scopeAnnotation
public interface MinProfilComponent {
    void inject(MinProfilActivity minProfilActivity);
}
