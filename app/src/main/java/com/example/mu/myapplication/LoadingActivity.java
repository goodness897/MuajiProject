package com.example.mu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {
    Handler hd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        hd = new Handler();
        hd.postDelayed(irun, 2500);

    }
    Runnable irun = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(LoadingActivity.this, MainActivity.class);
            startActivity(i);
            finish();       // 3 초후 이미지를 닫아버림

        }
    };


        @Override
    public void onBackPressed() {
        super.onBackPressed();
        hd.removeCallbacks(irun);

    }
}
