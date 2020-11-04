package com.example.movieapp;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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