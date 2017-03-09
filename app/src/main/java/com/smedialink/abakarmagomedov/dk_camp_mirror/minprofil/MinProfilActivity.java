package com.smedialink.abakarmagomedov.dk_camp_mirror.minprofil;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.BaseActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.login.LogInActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.managers.DataManager;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.SpinnerAdapter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class MinProfilActivity extends BaseActivity implements MinProfilView {

    @BindView(R.id.toolBarInActivityMinProfil) Toolbar mToolbar;
    @BindView(R.id.avatar_min_profil) RoundedImageView avatar;
    @BindView(R.id.name_min_profil) TextView name;
    @BindView(R.id.adress_min_profil) TextView adress;
    @BindView(R.id.min_postnr) TextView postnr;
    @BindView(R.id.min_mobil) TextView mobile;
    @BindView(R.id.min_email) TextView email;
    @BindView(R.id.min_date_of_birth) TextView birth;
    @BindView(R.id.status_min_profil) Button status;
    @BindView(R.id.seekBar2) SeekBar experience;
    @BindView(R.id.aendringer) Button aedringer;
    @BindView(R.id.mine_intereser_min_profil) Button interest;
    @BindView(R.id.mine_feriet_min_profil) Button feriet;
    @Inject Presenter mMinPresenter;

    @OnTouch(R.id.seekBar2)
    boolean onTouch(){
        return true;
    }

    @OnClick(R.id.mine_intereser_min_profil)
    void onInterestClick(View view){
        mMinPresenter.clikced(view.getId());
    }

    @OnClick(R.id.mine_feriet_min_profil)
    void onFerietClick(View view){
        mMinPresenter.clikced(view.getId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_profil);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
        App.get().getAppComponent().plusMinProfilComponent(new PresenterModule(this)).inject(this);
        mMinPresenter.fetchData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu_logud, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_ud:
                mMinPresenter.setUserNotExist();
                start(LogInActivity.class);
                return true;
        }
        return false;
    }

    @Override
    public void success(User user) {
        name.setText(user.getFirstName());
        adress.setText(user.getAddresslineOne());
        postnr.setText(user.getPostNumber());
        mobile.setText(user.getMobileNumber());
        email.setText(user.getEmail());
        birth.setText(user.getBirthdayString());
        experience.setProgress(user.getCampingExperience());
    }

    @Override
    public void error() {

    }

    @Override
    public void showDlg(List<String> data) {
        showDialog(data);
    }
}



















