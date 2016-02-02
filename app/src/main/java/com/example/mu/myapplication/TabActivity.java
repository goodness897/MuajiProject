package com.example.mu.myapplication;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;

import android.widget.TabHost;

public class TabActivity extends FragmentActivity {

    TabHost tabHost;
    ViewPager pager;
    TabsAdapter mAdapter;
    private int type;
    private static final String TAB_TAG = "currentTab";
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        pager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new TabsAdapter(this, getSupportFragmentManager(), tabHost, pager);
        Intent intent = getIntent();
        type = intent.getExtras().getInt("type");
        intent.putExtra("type", type);


        switch (type) {
            case 0:

                mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("음식점").setContent(intent), Tab1.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("술집").setContent(intent), Tab2.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("카페"), Tab3.class, null);
                break;
            case 1:
                mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("공연").setContent(intent), Tab1.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("전시").setContent(intent), Tab2.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("공원").setContent(intent), Tab3.class, null);
                break;
            case 2:
                mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("쇼핑").setContent(intent), Tab1.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("노래방").setContent(intent), Tab2.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("당구장").setContent(intent), Tab3.class, null);
                break;
            case 3:
                mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("헤어").setContent(intent), Tab1.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("네일").setContent(intent), Tab2.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("세탁/수선").setContent(intent), Tab3.class, null);
                break;
        }


        mAdapter.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

            }
        });
        if (savedInstanceState != null) {
            mAdapter.onRestoreInstanceState(savedInstanceState);
            tabHost.setCurrentTabByTag(savedInstanceState.getString(TAB_TAG));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter.onSaveInstanceState(outState);
        outState.putString(TAB_TAG, tabHost.getCurrentTabTag());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

           SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
           SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
           search.setQueryHint("두 자 이상 입력하세요");
           search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

        }*/
        return true;
    }


    public int getType() {
        return type;
    }
}
