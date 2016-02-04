package com.example.mu.myapplication;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("그 거리 뭐 있소");

        ImageButton imageButton = (ImageButton) mCustomView
                .findViewById(R.id.search_image);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            }
        });

        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);

        spinner = (Spinner) findViewById(R.id.spinner);
        addspin = ArrayAdapter.createFromResource(this, R.array.university, android.R.layout.simple_spinner_item);
        addspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(addspin);
        spinner.setMinimumWidth(30);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

        btnShowLocation = (Button) findViewById(R.id.locationButton);
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
                    /*Toast.makeText(
                            getApplicationContext(),
                            "당신의 위치 - \n위도: " + latitude + "\n경도: " + longitude + "\n주소 : " + location,
                            Toast.LENGTH_LONG).show();*/
                } else {
                    // GPS 를 사용할수 없으므로
                    //  gps.showSettingsAlert();
                }
            }
        });


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
                    bf.append(currentLocationAddress).append("#");
                    bf.append(lat).append("#");
                    bf.append(lng);
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
}
