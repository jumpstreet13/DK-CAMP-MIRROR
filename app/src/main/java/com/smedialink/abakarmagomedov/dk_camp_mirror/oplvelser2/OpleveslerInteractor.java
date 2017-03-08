package com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2;


import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserActivityInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.util.List;

public interface OpleveslerInteractor {

    interface OnFinishedListener {
        void onError();
        void onSuccess(Discount item);
    }

    void fetchView(OpleveslerInteractor.OnFinishedListener listener);
}
