package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.smedialink.abakarmagomedov.dk_camp_mirror.network.MyWebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import butterknife.Optional;

public class SpilOgVilActivity extends AppCompatActivity {

    @BindView(R.id.toolBarInActivitySpilOgVil) Toolbar mToolbar;
    @BindView(R.id.bottomSheetInActivitySpilOg) View bottomSheet;
    @BindView(R.id.webViewInActivitySpilOgVil) WebView mWebView;
    @BindView(R.id.appBarInSpilOgVilActivity) AppBarLayout mAppBarLayout;
    //@BindView(R.id.progressBarInActivitySpilOg) ProgressBar mProgressBar;


    @OnTouch(R.id.webViewInActivitySpilOgVil)
    boolean onWebViewTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mAppBarLayout.setVisibility(View.GONE);
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case MotionEvent.ACTION_MOVE:
                mAppBarLayout.setVisibility(View.VISIBLE);
                break;
        }
        return false;
    }

    private BottomSheetBehavior mBottomSheetBehavior;


    public static void goTo(Context context) {
        Intent intent = new Intent(context, SpilOgVilActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_og_vil);
        ButterKnife.bind(this);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mWebView.loadUrl("http://ec2-52-11-181-117.us-west-2.compute.amazonaws.com/bingo/index.html");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
    }

    @Override
    protected void onStart() {
        super.onStart();
        bottomSheet.post(new Runnable() {
            @Override
            public void run() {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
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
                ChoiceActivity.goTo(this);
                return true;
        }
        return false;
    }

}
