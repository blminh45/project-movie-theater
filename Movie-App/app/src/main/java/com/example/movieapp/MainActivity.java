package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,PayActivity.class);
                ActivityOptions options;
                options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent,options.toBundle());
                finish();
            }
        },200);
    }
}