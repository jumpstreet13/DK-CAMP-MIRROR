package com.smedialink.abakarmagomedov.dk_camp_mirror.models;


import android.content.ClipData;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private Discount item;

    public Home(){
    }


    public void setFocusedItem(Discount item){
        this.item = item;
    }


    public Discount getFocusedItem(){
        return this.item;

    }
}
