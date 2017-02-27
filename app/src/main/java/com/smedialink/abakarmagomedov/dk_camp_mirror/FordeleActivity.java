package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;


public class FordeleActivity extends AppCompatActivity {

    //@BindView(R.id.toolBarInActivityFordele) Toolbar mToolbar;

    private Toolbar mToolbar;

    public static void goTo (Context context){
        Intent intent = new Intent(context, FordeleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fordele);
        mToolbar = (Toolbar) findViewById(R.id.toolBarInActivityFordele);
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
