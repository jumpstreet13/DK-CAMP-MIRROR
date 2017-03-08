package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.util.List;

public interface OplevelserActivityInteractor {

    void fetchOplevelsers(final OnFinishedListener listener);

    interface OnFinishedListener {
        void onError();
        void onSuccess(List<Discount> data);
    }

}
