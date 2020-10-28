package com.example.movieapp;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Phan cua Tam*/
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this,Notification.class);
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
//                startActivity(intent,options.toBundle());
//                finish();
//            }
//        },200);
    }
    public void NowSlide(View view) {
        Intent intent=new Intent(this,NowSlide.class);
        startActivity(intent);
    }
    public void WillSlide(View view) {
        Intent intent=new Intent(this,WillSlide.class);
        startActivity(intent);
    }
    public void Login(View view) {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    public void ListPhim(View view) {
        Intent intent=new Intent(this,ListMovieActivity.class);
        startActivity(intent);
    }


    public void Singup(View view) {
        Intent intent=new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }

    public void profile(View view) {
        Intent intent=new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}