package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.util.List;

public interface OplevelserFirstView {

    void onItemClick();
    void start();
    void success();
    void error();
    void show(List<OpleveslerItem> items);

}
