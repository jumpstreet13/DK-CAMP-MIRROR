package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;


import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.util.List;

public interface OplevelserFirstView {

    void sProgress();
    void hProgress();
    void onItemClick();
    void start();
    void success();
    void error();
    void show(List<Discount> items);
}
