package com.smedialink.abakarmagomedov.dk_camp_mirror.models;
import com.google.gson.annotations.SerializedName;


public class Discount {

    @SerializedName("uuid")
    private  String uuid;

    @SerializedName("title")
    private String title;

    @SerializedName("details")
    private String details;

    private int resId;

    @SerializedName(("url"))
    private String url;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("limited")
    private boolean limited;

    private boolean used;

    public Discount(){}

    public Discount (String title, String details, int resId, String url){
        this.title = title;
        this.details = details;
        this.resId = resId;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public int getRes() {
        return resId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public boolean isLimited() {
        return limited;
    }

    public void setLimited(boolean limited) {
        this.limited = limited;
    }

    public int getResId() {
        return resId;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isNotUsed(){
       return !used;
    }
}
