package com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa;


import com.smedialink.abakarmagomedov.dk_camp_mirror.MyDialog;

public interface TaetPaView {

    void showGpsDialog(MyDialog.MyDialogListener listener);
    void openGpsSettings();
    void checkGPS();
    void close();
    void getPermissions();
    void dissmisDialog();
}
