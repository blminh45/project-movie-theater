package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MakeSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        TextView title=findViewById(R.id.title_make),slogan=findViewById(R.id.slogan);
        RelativeLayout relative_sms = findViewById(R.id.sms);
        RelativeLayout relative_mail = findViewById(R.id.mail);
        title.setAnimation(animation);
        slogan.setAnimation(animation);
        relative_sms.setAnimation(animation);
        relative_mail.setAnimation(animation);
    }

    public void Continue(View view) {
        Intent intent = new Intent(this,VerifyOTP.class);
        startActivity(intent);
    }
    public void Back(View view) {
        Intent intent = new Intent(this,ForgotPassword.class);
        startActivity(intent);
    }
}