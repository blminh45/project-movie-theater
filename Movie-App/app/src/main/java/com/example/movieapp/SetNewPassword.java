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

public class SetNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        ImageView img = findViewById(R.id.set_password);
        TextView title=findViewById(R.id.title),slogan=findViewById(R.id.slogan);
        Button btn = findViewById(R.id.set_new_password_btn);
        TextInputLayout setPassword = findViewById(R.id.new_password),confirmPassword=findViewById(R.id.confirm_password);
        img.setAnimation(animation);
        title.setAnimation(animation);
        slogan.setAnimation(animation);
        btn.setAnimation(animation);
        setPassword.setAnimation(animation);
        confirmPassword.setAnimation(animation);

    }

    public void updateSuccess(View view) {
            Intent intent = new Intent(this,SuccessMessage.class);
            startActivity(intent);
    }
    public void Back(View view) {
        Intent intent = new Intent(this,VerifyOTP.class);
        startActivity(intent);
    }
}