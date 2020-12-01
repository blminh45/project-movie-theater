package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaos.view.PinView;

public class VerifyOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        TextView title=findViewById(R.id.title_verify),slogan=findViewById(R.id.slogan);
        PinView pin = findViewById(R.id.otp);
        Button btn = findViewById(R.id.verify_btn);
        title.setAnimation(animation);
        slogan.setAnimation(animation);
        btn.setAnimation(animation);
        pin.setAnimation(animation);
    }
    public void Continue(View view) {
        Intent intent = new Intent(this,SetNewPassword.class);
        startActivity(intent);
    }
    public void Back(View view) {
        Intent intent = new Intent(this,MakeSelection.class);
        startActivity(intent);
    }
}