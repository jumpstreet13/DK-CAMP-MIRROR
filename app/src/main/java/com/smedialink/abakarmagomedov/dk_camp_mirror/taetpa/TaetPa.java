package com.smedialink.abakarmagomedov.dk_camp_mirror.taetpa;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;

import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.BaseActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.HowedMenuActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.MyDialog;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;
import com.smedialink.abakarmagomedov.dk_camp_mirror.utils.ConstantManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaetPa extends BaseActivity implements TaetPaView {

    @BindView(R.id.toolBar_in_activity_taet_pa) Toolbar mToolbar;
    @BindView(R.id.slideBar) SeekBar mSeekBar;
    @BindView(R.id.dissapear_text) TextView text;
    @Inject TaetPaPresenter mPresenter;

    private MyDialog mMyDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taet_pa);
        ButterKnife.bind(this);
        setToolbar(mToolbar);

        App.get().getAppComponent().plusTaetComponent(new PresenterModule(this)).inject(this);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ObjectAnimator rip = ObjectAnimator.ofFloat(text, "alpha", 1 - progress/100);
                rip.setDuration(500);
                rip.start();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() > seekBar.getMax()/2){
                    ObjectAnimator animation = ObjectAnimator.ofInt(seekBar, "progress", seekBar.getMax());
                    animation.setDuration(500);
                    animation.setInterpolator(new DecelerateInterpolator());
                    animation.start();
                }

                if(seekBar.getProgress() < seekBar.getMax()/2){
                    ObjectAnimator animation = ObjectAnimator.ofInt(seekBar, "progress", 0);
                    animation.setDuration(500);
                    animation.setInterpolator(new DecelerateInterpolator());
                    animation.start();
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.checkPermissions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:
                start(HowedMenuActivity.class);
                return true;
        }
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == ConstantManager.PERMISSION_REQUEST_LOCATION && grantResults.length == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mPresenter.checkPermissions();
            } else {
                close();
            }
        }
    }

    @Override
    public void showGpsDialog(MyDialog.MyDialogListener listener) {
        mMyDialog = new MyDialog(this, R.layout.gps_dialog, R.id.positive_gps_dialog, R.id.negative_gps_dialog, listener);
        mMyDialog.show();
    }

    @Override
    public void getPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ConstantManager.PERMISSION_REQUEST_LOCATION);
    }


    @Override
    public void dissmisDialog() {
        mMyDialog.cancel();
    }

    @Override
    public void openGpsSettings() {
        openApplicationSettings();
    }

    @Override
    public void checkGPS() {
        if (!hasGPSConnection()) mPresenter.getGPS();
    }

    @Override
    public void close() {
        finish();
    }

}
