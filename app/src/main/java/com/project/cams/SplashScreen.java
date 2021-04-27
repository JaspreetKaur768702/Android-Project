package com.project.cams;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        initView();
    }
    private void initView() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(PreferenceManager.getDefaultSharedPreferences(SplashScreen.this).getString("userType","").isEmpty()){
                    Intent loginIntent = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
                }
                else {
                    Intent loginIntent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(loginIntent);
                    finish();
                }

            }

        }, 3000);
    }

}