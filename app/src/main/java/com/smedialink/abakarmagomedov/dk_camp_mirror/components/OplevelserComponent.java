package com.smedialink.abakarmagomedov.dk_camp_mirror.components;

import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirst;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LogInActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.InteractorModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.scopeAnnotation;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerActivitySecond;

import dagger.Subcomponent;


@Subcomponent(modules = {InteractorModule.class, PresenterModule.class})
@scopeAnnotation
public interface OplevelserComponent {
    void inject(OplevelserActivityFirst oplevelserActivityFirst);
    void inject(OpleveslerActivitySecond opleveslerActivitySecond);
    void inject(LogInActivity loginActivity);
}
