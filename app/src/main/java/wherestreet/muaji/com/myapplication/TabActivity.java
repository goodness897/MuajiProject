package wherestreet.muaji.com.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class TabActivity extends FragmentActivity {

    TabHost tabHost;
    ViewPager pager;
    TabsAdapter mAdapter;
    private int type;
    private static final String TAB_TAG = "currentTab";

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

        String title = getString(R.string.app_name);
        setActionBar(title);

        switch (type) {
            case 0:

                mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("음식점").setContent(intent), Tab1.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("술집").setContent(intent), Tab2.class, null);
                mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("카페").setContent(intent), Tab3.class, null);
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
        TabWidget widget = tabHost.getTabWidget();
        for(int i = 0; i < widget.getChildCount(); i++) {
            View v = widget.getChildAt(i);

            // Look for the title view to ensure this is an indicator and not a divider.
            TextView tv = (TextView)v.findViewById(android.R.id.title);
            if(tv == null) {
                continue;
            }
            v.setBackgroundResource(R.drawable.tab_indicator_green);
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

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        *//*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

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

        }*//*
        return true;
    }
*/

    public int getType() {
        return type;
    }
    public void setActionBar(String title){

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);

        final TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        final EditText searchEdit = (EditText)mCustomView.findViewById(R.id.search_text);
        mTitleTextView.setText(title);
        mTitleTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton = (ImageButton) mCustomView
                .findViewById(R.id.search_image);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                MainActivity.flag = !MainActivity.flag;
                if(MainActivity.flag){ //검색창 활성화
                    searchEdit.setVisibility(View.VISIBLE);
                    mTitleTextView.setVisibility(View.GONE);
                } else { // 검색
                    searchEdit.setVisibility(View.GONE);
                    mTitleTextView.setVisibility(View.VISIBLE);
                }
            }
        });
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);

    }
}
