package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FordeleActivity extends BaseActivity{

    @BindView(R.id.toolBarInActivityFordele) Toolbar mToolbar;

    @OnClick(R.id.opleveslerImageButton)
    void onOpleveslerClick() {start(OplevelserActivityFirst.class);}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fordele);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
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
}
