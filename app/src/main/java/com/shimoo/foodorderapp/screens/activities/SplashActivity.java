package com.shimoo.foodorderapp.screens.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.shimoo.foodorderapp.R;

public class SplashActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                     Intent intent = new Intent(SplashActivity.this,
                             LoginActivity.class);
                    startActivity(intent);
                    finish();






//
            }
        }, 4000);

    }


}
