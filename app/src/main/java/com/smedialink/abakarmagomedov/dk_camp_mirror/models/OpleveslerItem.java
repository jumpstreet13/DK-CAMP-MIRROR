package com.smedialink.abakarmagomedov.dk_camp_mirror.models;



public class OpleveslerItem {
    private String bigText;
    private String smallText;
    private int image;

    public OpleveslerItem(String bigText, String smallText, int image) {
        this.bigText = bigText;
        this.smallText = smallText;
        this.image = image;
    }

    public String getBigText() {
        return bigText;
    }

    public void setBigText(String bigText) {
        this.bigText = bigText;
    }

    public String getSmallText() {
        return smallText;
    }

    public void setSmallText(String smallText) {
        this.smallText = smallText;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
