package com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil;


import com.smedialink.abakarmagomedov.dk_camp_mirror.MyDialog;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

import java.util.List;

public interface MinProfilView {

    void success(User user);
    void error();
    void showDlg(List<String> data);
    void showAlertDialog(MyDialog.MyDialogListener listener);
    void dissmissDialog();
    void goToChoice();
}
