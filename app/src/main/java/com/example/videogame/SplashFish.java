package com.example.videogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashFish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_fish);


        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    Intent I = new Intent(SplashFish.this, Fish.class);
                    startActivity(I);
                }

            }

        };

        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();


        finish();
    }
}

