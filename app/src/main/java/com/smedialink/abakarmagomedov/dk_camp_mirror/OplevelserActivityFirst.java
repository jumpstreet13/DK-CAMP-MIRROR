package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.smedialink.abakarmagomedov.dk_camp_mirror.models.Home;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerAdapter;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OplevelserActivityFirst extends AppCompatActivity {

   @BindView(R.id.toolBarInActivityOplevelserFirst)  Toolbar mToolbar;
   @BindView(R.id.recyclerViewInActivityOplevesler) RecyclerView mRecyclerView;


    public static void start(Context context){
        Intent intent = new Intent(context, OplevelserActivityFirst.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oplevelser_first);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Home home = Home.getInstanse();
        home.setItems(createFakeData());
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
        switch (item.getItemId()){
            case R.id.menu:
                ChoiceActivity.start(this);
                return true;
        }
        return false;
    }

    public List<OpleveslerItem> createFakeData(){
        OpleveslerItem opleveslerItem = new OpleveslerItem("JENSENS BØFHUS",
                "Ria sus dolorest eratibu stiatur aut ad quae nonsequae corit et quatis ad quinda si bl", R.drawable.background_bil_vogn);
        OpleveslerItem opleveslerItem2 = new OpleveslerItem("FÅRUP SOMMERLAND",
                "Ria sus dolorest eratibad quae nonsequae corit et quat omnis ad qui audanda si bl", R.drawable.background_rabatter);
        OpleveslerItem opleveslerItem3 = new OpleveslerItem("BIG TEXT", "some small text about another things", R.drawable.background_log_in);
        ArrayList<OpleveslerItem> arrayList = new ArrayList<>();
        arrayList.add(opleveslerItem);
        arrayList.add(opleveslerItem2);
        arrayList.add(opleveslerItem3);
        return arrayList;
    }


}
