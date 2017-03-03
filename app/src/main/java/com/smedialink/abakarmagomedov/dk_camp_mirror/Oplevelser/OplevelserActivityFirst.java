package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.smedialink.abakarmagomedov.dk_camp_mirror.BaseActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.HowedMenuActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.OpleveslerActivitySecond;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OplevelserActivityFirst extends BaseActivity implements OplevelserFirstView {

    @BindView(R.id.toolBarInActivityOplevelserFirst) Toolbar mToolbar;
    @BindView(R.id.recyclerViewInActivityOplevesler) RecyclerView mRecyclerView;

    private OplevelserActivityFirstPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oplevelser_first);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
        mPresenter = new OplevelserActivityFirstPresenter(this, new OplevelserActivityFirstInteractor());
        Home home = Home.getInstanse();
        home.setItems(mPresenter.getFakeData());
        OpleveslerAdapter adapter = new OpleveslerAdapter(home.getItems(), this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
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
    public void invoke() {
        mPresenter.invoke();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }

    @Override
    public void start() {
        start(OpleveslerActivitySecond.class);
    }
}
