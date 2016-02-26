package com.example.mu.myapplication;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MainActivity extends Activity {
    private Intent intent;
    private ArrayAdapter<CharSequence> addspin;
    private Spinner spinner;
    private Button btnShowLocation;
    private TextView textShowLocation;
    private String currentLocationAddress;
    private GpsInfo gps;
    static boolean flag = false;
    private String title;
    private String location;
    private String[] arrayForSpinner;
    TextView label;
    Button foodButton;
    Button showButton;
    Button funButton;
    Button enjoyButton;
    private boolean local = false;
    private ListView drawerList;
    private String[] navItems = {"우리 모두 소개", "김아연", "박무성", "박지훈" };
    private DrawerLayout mDrawerLayout;
    private boolean mSlideState = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayForSpinner = getResources().getStringArray(R.array.university);
        drawerList = (ListView)findViewById(R.id.lv_activity_main_nav_list);
        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,navItems));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout)findViewById(R.id.my_drawer_layout);
        mDrawerLayout.setDrawerListener(new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, 0, 0){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mSlideState = false;//is Closed
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mSlideState = true;//is Opened
            }});

        // 폰트 변경
        /*foodButton = (Button)findViewById(R.id.buttonFood);
        foodButton.setTypeface(Typeface.createFromAsset(getAssets(), "NanumGothic.ttf"));
        showButton = (Button)findViewById(R.id.buttonShow);
        showButton.setTypeface(Typeface.createFromAsset(getAssets(), "NanumGothicBold.ttf"));
        funButton = (Button)findViewById(R.id.buttonFun);
        funButton.setTypeface(Typeface.createFromAsset(getAssets(), "NanumGothicExtraBold.ttf"));
        enjoyButton = (Button)findViewById(R.id.buttonEnjoy);*/

        // make ActionBar
        title = getString(R.string.app_name);
        setActionBar(title);
        spinner = (Spinner) findViewById(R.id.spinner);
        local = true;
        if(local){
            location = setLocation();
        }

        System.out.println("위치는 : " +location);
        if(location != null){
            spinner.setAdapter(new CustomSpinnerAdapter(this, R.layout.spinner_row, arrayForSpinner, location));
        }

        /*addspin = ArrayAdapter.createFromResource(this, R.array.university, android.R.layout.simple_spinner_item);
        addspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(addspin);
        spinner.setMinimumWidth(30);
*/
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            String item = (String) spinner.getSelectedItem();
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ImageView imgView = (ImageView) findViewById(R.id.animationImage);
        imgView.setVisibility(ImageView.VISIBLE);

        final AnimationDrawable drawable = (AnimationDrawable) imgView.getBackground();
        drawable.setEnterFadeDuration(800);
        drawable.setExitFadeDuration(800);
        drawable.start();
        /*btnShowLocation = (Button) findViewById(R.id.locationButton);
        textShowLocation = (TextView) findViewById(R.id.locationText);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gps = GpsInfo.getLocationManager(MainActivity.this);
                // GPS 사용유무 가져오기
                if (gps.isGetLocation()) {
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    String location = findAddress(latitude, longitude);
                    textShowLocation.setText(location);
                    *//*Toast.makeText(
                            getApplicationContext(),
                            "당신의 위치 - \n위도: " + latitude + "\n경도: " + longitude + "\n주소 : " + location,
                            Toast.LENGTH_LONG).show();*//*
                } else {
                    // GPS 를 사용할수 없으므로
                    //  gps.showSettingsAlert();
                }
            }
        });*/


    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
            selectItem(position);
            Toast.makeText(getApplicationContext(), (String)drawerList.getSelectedItem() , Toast.LENGTH_LONG).show();
        }
    }
    public void selectItem(int position){
        if(position == 0){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("http://mooajee.modoo.at/");
            intent.setData(uri);
            startActivity(intent);

        }else {

        }
    }
    public String setLocation() {
        gps = GpsInfo.getLocationManager(MainActivity.this);
        String current_location = "성남시";
        // GPS 사용유무 가져오기
        if (gps.isGetLocation()) {
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            current_location = findAddress(latitude, longitude);
            label = (TextView) findViewById(R.id.spinner_text);
            local = false;
        } else {
            // GPS 를 사용할수 없으므로
            //  gps.showSettingsAlert();
        }
        return current_location;

    }
    // Custom 스피너
    public class CustomSpinnerAdapter extends ArrayAdapter<String>{

        Context context;
        String[] objects;
        String firstElement;
        boolean isFirstTime;

        public CustomSpinnerAdapter(Context context, int textViewResourceId, String[] objects, String defaultText) {
            super(context, textViewResourceId, objects);
            this.context = context;
            this.objects = objects;
            this.isFirstTime = true;
            setDefaultText(defaultText);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if(isFirstTime) {
                objects[0] = firstElement;
                isFirstTime = false;
            }
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            notifyDataSetChanged();
            return getCustomView(position, convertView, parent);
        }

        public void setDefaultText(String defaultText) {
            this.firstElement = objects[0];
            objects[0] = defaultText;
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.spinner_row, parent, false);
            label = (TextView) row.findViewById(R.id.spinner_text);
            label.setText(objects[position]);
            return row;
        }

    }

    /* public void onWindowFocusChanged(boolean hasFocus) {
         super.onWindowFocusChanged(hasFocus);
         ImageView img_change = (ImageView) findViewById(R.id.animationImage);
         Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.simple_animation);
         AnimationDrawable splashAnimation = (AnimationDrawable) img_change.getBackground();
         if(hasFocus) {
             img_change.setAnimation(animationFadeIn);

             splashAnimation .setEnterFadeDuration(500);
             splashAnimation .setExitFadeDuration(500);

             splashAnimation.start();
         }}
 */
   /* public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        ImageView imgView = (ImageView)findViewById(R.id.animationImage);
        imgView.setVisibility(ImageView.VISIBLE);

      *//*  Animation hyperspaceJump =
                AnimationUtils.loadAnimation(this, R.anim.simple_animation);
        imgView.startAnimation(hyperspaceJump);*//*
        imgView.setBackgroundResource(R.anim.simple_animation);
        AnimationDrawable frameAnimation = (AnimationDrawable) imgView.getBackground();
        frameAnimation.start();
        super.onWindowFocusChanged(hasFocus);
    }*/

    // 위치기반 주소찾기
    private String findAddress(double lat, double lng) {
        StringBuffer bf = new StringBuffer();
        Geocoder geocoder = new Geocoder(this, Locale.KOREA);
        List<Address> address;
        try {
            if (geocoder != null) {
                // 세번째 인수는 최대결과값인데 하나만 리턴받도록 설정했다
                address = geocoder.getFromLocation(lat, lng, 1);
                // 설정한 데이터로 주소가 리턴된 데이터가 있으면
                if (address != null && address.size() > 0) {
                    // 주소
                    currentLocationAddress = address.get(0).getAddressLine(0).toString();

                    // 전송할 주소 데이터 (위도/경도 포함 편집)
                    /*bf.append(currentLocationAddress).append("#");
                    bf.append(lat).append("#");
                    bf.append(lng);*/
                    bf.append(currentLocationAddress);
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return bf.toString();
    }

    public void onBtnFoodClicked(View v) {
        intent = new Intent(this, TabActivity.class);
        intent.putExtra("type", 0);
        startActivity(intent);
    }

    public void onBtnShowClicked(View v) {
        intent = new Intent(this, TabActivity.class);
        intent.putExtra("type", 1);
        startActivity(intent);
    }

    public void onBtnFunClicked(View v) {
        intent = new Intent(this, TabActivity.class);
        intent.putExtra("type", 2);
        startActivity(intent);
    }

    public void onBtnEnjoyClicked(View v) {
        intent = new Intent(this, TabActivity.class);
        intent.putExtra("type", 3);
        startActivity(intent);
    }

    public void onImageClicked(View v) {
        intent = new Intent(this, CouponActivity.class);
        startActivity(intent);
    }

    public void onRefreshButton(View v){
        setLocation();
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
        mTitleTextView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton searchButton = (ImageButton) mCustomView
                .findViewById(R.id.search_image);
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                flag = !flag;
                if (flag) { //검색창 활성화
                    searchEdit.setVisibility(View.VISIBLE);
                    mTitleTextView.setVisibility(View.GONE);
                } else { // 검색
                    searchEdit.setVisibility(View.GONE);
                    mTitleTextView.setVisibility(View.VISIBLE);
                }
            }
        });
        ImageButton drawerButton = (ImageButton) mCustomView.findViewById(R.id.drawer_image);
        drawerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mSlideState) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                }
            }
    });
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);

    }

    public void onModooClicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);

        Uri uri = Uri.parse("http://mooajee.modoo.at/");
        intent.setData(uri);
        startActivity(intent);

    }


}
