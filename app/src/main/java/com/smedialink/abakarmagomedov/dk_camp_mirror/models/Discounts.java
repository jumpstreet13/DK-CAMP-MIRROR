package com.smedialink.abakarmagomedov.dk_camp_mirror.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Discounts {

    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private List<Discount> data;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Discount> getData() {
        return data;
    }

    public void setData(List<Discount> data) {
        this.data = data;
    }
}
