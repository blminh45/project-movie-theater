package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Notification extends AppCompatActivity {
    private static int SPLASH_SCREEN = 3000;
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo,slogan,nameapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_notification);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image=findViewById(R.id.img);
        logo = findViewById(R.id.logo);
        slogan = findViewById(R.id.slogan);
        nameapp = findViewById(R.id.nameapp);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);
        nameapp.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Notification.this,MainActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(image,"logo_image");
                pairs[1] = new Pair<View,String>(logo,"logo_text");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Notification.this,pairs);
                startActivity(intent,options.toBundle());
                finish();
            }
        },SPLASH_SCREEN);
    }
}