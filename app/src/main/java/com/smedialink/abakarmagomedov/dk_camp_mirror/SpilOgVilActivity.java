package com.smedialink.abakarmagomedov.dk_camp_mirror;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.smedialink.abakarmagomedov.dk_camp_mirror.network.MyWebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

@SuppressLint("SetJavaScriptEnabled")
public class SpilOgVilActivity extends BaseActivity {

    @BindView(R.id.toolBarInActivitySpilOgVil) Toolbar mToolbar;
    @BindView(R.id.bottomSheetInActivitySpilOg) View bottomSheet;
    @BindView(R.id.webViewInActivitySpilOgVil) WebView mWebView;
    @BindView(R.id.appBarInSpilOgVilActivity) AppBarLayout mAppBarLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_og_vil);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mWebView.loadUrl(getIntent().getStringExtra(IntentUtils.WEB));
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
        switch (item.getItemId()) {
            case R.id.menu:
                start(HowedMenuActivity.class);
                return true;
        }
        return false;
    }

}
