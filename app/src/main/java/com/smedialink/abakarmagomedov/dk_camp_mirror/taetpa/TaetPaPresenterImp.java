package com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa;


import com.smedialink.abakarmagomedov.dk_camp_mirror.MyDialog;

import java.lang.ref.WeakReference;

public class TaetPaPresenterImp implements TaetPaPresenter, TaetPaInteractor.onFinishedListener, MyDialog.MyDialogListener {

    private final WeakReference<TaetPaView> mView;
    private TaetPaInteractor mInteractor;


    public TaetPaPresenterImp(TaetPaView view, TaetPaInteractor interactor) {
        mView = new WeakReference<>(view);
        mInteractor = interactor;
    }

    @Override
    public void onSuccess() {
        TaetPaView taetPaView = mView.get();
        if (taetPaView != null) {
            taetPaView.checkGPS();
        }
    }

    @Override
    public void onError() {
        TaetPaView taetPaView = mView.get();
        if (taetPaView != null) {
            taetPaView.getPermissions();
        }
    }

    @Override
    public void onPositive() {
        TaetPaView taetPaView = mView.get();
        if (taetPaView != null) {
            taetPaView.openGpsSettings();
            taetPaView.dissmisDialog();
        }
    }

    @Override
    public void onNegative() {
        TaetPaView taetPaView = mView.get();
        if (taetPaView != null) {
            taetPaView.dissmisDialog();
            taetPaView.close();
        }
    }

    @Override
    public void checkPermissions() {
        mInteractor.checkPermissions(this);
    }

    @Override
    public void getGPS() {
        TaetPaView taetPaView = mView.get();
        if (taetPaView != null) {
            taetPaView.showGpsDialog(this);
        }

    }
}
