package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        ImageView img = findViewById(R.id.icon_forgot);
        TextView title=findViewById(R.id.title_forgot),slogan=findViewById(R.id.forgotpassword);
        TextInputLayout textaccount = findViewById(R.id.account);
        Button btn = findViewById(R.id.btn_continue);
        img.setAnimation(animation);
        title.setAnimation(animation);
        slogan.setAnimation(animation);
        btn.setAnimation(animation);
        textaccount.setAnimation(animation);
    }

    public void Continue(View view) {
        Intent intent = new Intent(this,MakeSelection.class);
        startActivity(intent);
        finish();
    }
    public void Back(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}