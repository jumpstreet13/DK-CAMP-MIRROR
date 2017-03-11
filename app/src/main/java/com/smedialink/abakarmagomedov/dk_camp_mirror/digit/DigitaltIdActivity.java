package com.smedialink.abakarmagomedov.dk_camp_mirror.digit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.BaseActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.HowedMenuActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.User;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DigitaltIdActivity extends BaseActivity implements DigView {

    @BindView(R.id.toolBarInActivityDigitaItId) Toolbar mToolbar;
    @BindView(R.id.name_digit) TextView mName;
    @BindView(R.id.mobil_digit) TextView mMobil;
    @BindView(R.id.email_digit) TextView mEmail;
    @BindView(R.id.address_digit) TextView mAddress;
    @BindView(R.id.unical_digit) TextView mUnical;
    @Inject DigPresenter mDigPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digitalt_id);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
        App.get().getAppComponent().plusDigComponent(new PresenterModule(this)).inject(this);
        mDigPresenter.fetchData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu:
                start(HowedMenuActivity.class);
                return true;
        }
        return false;
    }

    @Override
    public void show(User user) {
        mName.setText(user.getFullName());
        mMobil.setText(user.getMobileNumber());
        mEmail.setText(user.getEmail());
        mAddress.setText(user.getAddresslineOne());
        mUnical.setText(user.getAddresslineOne());
    }
}
