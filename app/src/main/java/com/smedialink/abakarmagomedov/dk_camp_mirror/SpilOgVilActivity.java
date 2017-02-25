package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;

public class SpilOgVilActivity extends AppCompatActivity {

   // @BindView(R.id.toolBarInActivityOplevelserFirst) Toolbar mToolbar;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_og_vil);
        mToolbar = (Toolbar) findViewById(R.id.toolBarInActivitySpilOgVil);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        MenuItem item = menu.findItem(R.id.menu);
        item.setActionView(R.layout.menu_item);
        return true;
    }
}