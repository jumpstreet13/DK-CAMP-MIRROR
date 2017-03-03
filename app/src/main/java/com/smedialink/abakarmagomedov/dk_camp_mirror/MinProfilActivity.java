package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.LoginFilter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MinProfilActivity extends BaseActivity{

    @BindView(R.id.toolBarInActivityMinProfil) Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_profil);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu_logud, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.log_ud:
                start(LogInActivity.class);
                return true;
        }
        return false;
    }
}
