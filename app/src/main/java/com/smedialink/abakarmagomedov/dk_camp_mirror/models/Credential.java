package com.smedialink.abakarmagomedov.dk_camp_mirror.models;



public class Credential {

    private final String userName;
    private final String userPassword;


    public Credential(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
