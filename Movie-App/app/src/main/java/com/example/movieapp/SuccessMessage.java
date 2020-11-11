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

public class SuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_message);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        ImageView img = findViewById(R.id.icon_success);
        TextView title=findViewById(R.id.title),slogan=findViewById(R.id.slogan_update);
        Button btn = findViewById(R.id.btn_login);
        img.setAnimation(animation);
        title.setAnimation(animation);
        slogan.setAnimation(animation);
        btn.setAnimation(animation);
    }

    public void callLogin(View view) {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
    }
    public void Back(View view) {
        Intent intent = new Intent(this,SetNewPassword.class);
        startActivity(intent);
    }
}