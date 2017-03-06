package com.smedialink.abakarmagomedov.dk_camp_mirror;

import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityFirst;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.InteractorModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.pre;

import javax.inject.Scope;

import dagger.Provides;
import dagger.Subcomponent;


@Subcomponent(modules = {InteractorModule.class, PresenterModule.class})
@pre
public interface OplevelserComponent {
    void inject(OplevelserActivityFirst oplevelserActivityFirst);
}
