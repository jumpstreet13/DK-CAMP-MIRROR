package com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.BaseActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.HowedMenuActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OpleveslerActivitySecond extends BaseActivity implements OpleveslerView {

    @BindView(R.id.toolBarInActivityOplevelserSecond) Toolbar mToolbar;
    @BindView(R.id.imageviewInActivityOpleveslerSecond) ImageView mImageView;
    @BindView(R.id.bigTextViewInActivityOpleveslerSecond) TextView bigText;
    @BindView(R.id.smallTextViewInActivityOpleveslerSecond) TextView smallText;
    @Inject OpleveslerPresenter mOplevelserActivityPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oplevesler_second);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
        App.get().getAppComponent().plusOplevelserComponent2(new PresenterModule(this)).inject(this);
        mOplevelserActivityPresenter.fetchData();
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
                mOplevelserActivityPresenter.start();
                return true;
        }
        return false;
    }

    @Override
    public void setViews(Discount item){
        bigText.setText(item.getTitle());
        smallText.setText(item.getDetails());
        Glide.with(this).load(item.getImageUrl())
                .into(mImageView);
    }

    @Override
    public void start() {
        start(HowedMenuActivity.class, Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
