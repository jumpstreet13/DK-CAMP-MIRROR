package com.smedialink.abakarmagomedov.dk_camp_mirror.login;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.BaseActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.HowedMenuActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogInActivity extends BaseActivity implements LoginView {

    @BindView(R.id.toolBarInActivityLog) Toolbar mToolbar;
    @Inject LoginPresenter mLoginPresenter;

    @OnClick(R.id.buttonlogInActivityLogiN)
    void onButtonClick(View v) {
        mLoginPresenter.click(v.getId());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
        App.get().getAppComponent().plusLoginComponent(new PresenterModule(this)).inject(this);
    }


    @Override
    public void sProgress() {
        showProgress();
    }

    @Override
    public void hProgress() {
        hideProgress();
    }

    @Override
    public void error() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        start(HowedMenuActivity.class);
    }
}
