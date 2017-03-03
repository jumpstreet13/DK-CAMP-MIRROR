package com.smedialink.abakarmagomedov.dk_camp_mirror.models;


import java.util.ArrayList;
import java.util.List;

public class Home {
    private static Home instanse;
    private List<OpleveslerItem> items;

    private Home(){
    }

    public static Home getInstanse(){
        if(instanse == null){
            instanse = new Home();
        }
        return instanse;
    }

    public void setItems(List<OpleveslerItem> items){
        if(this.items == null || this.items.isEmpty()){
            this.items = new ArrayList<>();
            this.items.addAll(items);
        }
    }


    public OpleveslerItem getFocusedItem(){
        for(OpleveslerItem opleveslerItem : items){
            if(opleveslerItem.getFocused()){
                return opleveslerItem;
            }
        }
        return null;
    }

    public List<OpleveslerItem> getItems(){
        return items;
    }

}
