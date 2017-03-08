package com.smedialink.abakarmagomedov.dk_camp_mirror.models;


import android.content.ClipData;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private static Home instanse;
    private Discount item;

    private Home(){
    }

    public static Home getInstanse(){
        if(instanse == null){
            instanse = new Home();
        }
        return instanse;
    }

    public void setFocusedItem(Discount item){
        this.item = item;
    }


    public Discount getFocusedItem(){
        return this.item;

    }
}
