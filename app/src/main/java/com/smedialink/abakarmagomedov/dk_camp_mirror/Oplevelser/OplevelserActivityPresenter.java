package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;

public interface OplevelserActivityPresenter {

    void invoke(Discount item);
    void fetchData();
    void refreshData();
}
