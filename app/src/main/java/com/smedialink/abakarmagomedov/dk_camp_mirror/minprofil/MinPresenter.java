package com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil;

import android.content.DialogInterface;

import com.smedialink.abakarmagomedov.dk_camp_mirror.MyDialog;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;

import java.lang.ref.WeakReference;
import java.util.List;

public class MinPresenter implements Presenter, MinInteractor.OnFinishedListener, MyDialog.MyDialogListener {

    private final WeakReference<MinProfilView> mView;
    private Interactor mInteractor;

    public MinPresenter(MinProfilView view, Interactor interactor) {
        this.mView = new WeakReference<>(view);
        mInteractor = interactor;
    }

    @Override
    public void onError() {
        MinProfilView view = mView.get();
        if (view != null) {
            view.error();
        }
    }

    @Override
    public void onSuccess(User user) {
        MinProfilView view = mView.get();
        if (view != null) {
            view.success(user);
        }
    }

    @Override
    public void onInterestSucces(List<String> list) {
        MinProfilView view = mView.get();
        if (view != null) {
            view.showDlg(list);
        }
    }

    @Override
    public void onInterestError(List<String> list) {
        MinProfilView view = mView.get();
        if (view != null) {
            view.showDlg(list);
        }
    }

    @Override
    public void onFerietSucces(List<String> list) {

    }

    @Override
    public void onFerietError(List<String> list) {

    }

    @Override
    public void fetchData() {
        mInteractor.getUserData(this);
    }

    @Override
    public void setUserNotExist() {
        mInteractor.deleteUser();
    }

    @Override
    public void clikced(int id) {
        switch (id) {
            case R.id.mine_intereser_min_profil:
                mInteractor.getInterests(this);
                break;
            case R.id.mine_feriet_min_profil:
                mInteractor.getFeriet(this);
                break;
        }
    }

    @Override
    public void showExitDialog() {
        MinProfilView view = mView.get();
        if (view != null) {
            view.showAlertDialog(this);
        }
    }

    @Override
    public void onPositive() {
        MinProfilView view = mView.get();
        if (view != null) {
            view.goToLogin();
        }
    }

    @Override
    public void onNegative() {
        MinProfilView view = mView.get();
        if (view != null) {
            view.dissmissDialog();
        }
    }
}
