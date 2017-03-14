package com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.smedialink.abakarmagomedov.dk_camp_mirror.digit.DigInteractor;
import com.smedialink.abakarmagomedov.dk_camp_mirror.utils.ConstantManager;

public class TaetPaInteractorImp implements TaetPaInteractor {
    private Context mContext;

    public TaetPaInteractorImp(Context context){
        this.mContext = context;
    }


    @Override
    public void checkPermissions(TaetPaInteractor.onFinishedListener listener) {
        if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) listener.onSuccess();
        else listener.onError();
    }


}
