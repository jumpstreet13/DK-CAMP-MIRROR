package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OpleveslerActivitySecond extends AppCompatActivity {

    @BindView(R.id.toolBarInActivityOplevelserSecond) Toolbar mToolbar;
    @BindView(R.id.imageviewInActivityOpleveslerSecond) ImageView mImageView;
    @BindView(R.id.bigTextViewInActivityOpleveslerSecond) TextView bigText;
    @BindView(R.id.smallTextViewInActivityOpleveslerSecond) TextView smallText;

    public static void start(Context context){
        Intent intent = new Intent(context, OpleveslerActivitySecond.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oplevesler_second);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Home home = Home.getInstanse();
        setViews(home.getFocusedItem());
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
                ChoiceActivity.start(this);
                return true;
        }
        return false;
    }

    public void setViews(OpleveslerItem item){
        mImageView.setImageResource(item.getImage());
        bigText.setText(item.getBigText());
        smallText.setText(item.getSmallText());
        item.setFocused(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
