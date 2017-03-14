package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.DecelerateInterpolator;
import android.widget.SeekBar;

import com.smedialink.abakarmagomedov.dk_camp_mirror.utils.IntentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.toolBarInActivitySignUp) Toolbar mToolbar;
    @OnClick(R.id.button_tilmeld)
    void onClick(){
        startInternet(IntentUtils.TILMELD);
    }

    private ObjectAnimator anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
    }
}
