package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.smedialink.abakarmagomedov.dk_camp_mirror.App;
import com.smedialink.abakarmagomedov.dk_camp_mirror.BaseActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.HowedMenuActivity;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Discount;
import com.smedialink.abakarmagomedov.dk_camp_mirror.oplvelser2.OpleveslerActivitySecond;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerAdapter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.modules.PresenterModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OplevelserActivityFirst extends BaseActivity implements OplevelserFirstView {

    @Inject OplevelserActivityPresenter mPresenter;
    @BindView(R.id.toolBarInActivityOplevelserFirst) Toolbar mToolbar;
    @BindView(R.id.recyclerViewInActivityOplevesler) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oplevelser_first);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
        App.get().getAppComponent().plusOplevelserComponent(new PresenterModule(this)).inject(this);
        mPresenter.fetchData();
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
    public void onItemClick() {
        mPresenter.invoke();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void start() {
        start(OpleveslerActivitySecond.class);
    }

    @Override
    public void sProgress() {
        showProgress();
    }

    @Override
    public void hProgress() {
        hideProgress();
    }


    @Override
    public void success() {

    }

    @Override
    public void error() {

    }




    @Override
    public void show(List<Discount> items) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        OpleveslerAdapter adapter = new OpleveslerAdapter(items, this);
        mRecyclerView.setAdapter(adapter);
    }

}
