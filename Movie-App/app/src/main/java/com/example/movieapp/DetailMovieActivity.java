package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DetailMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
    }
    public void watchtrailer(View view) {
        Intent trailer = new Intent(Intent.ACTION_VIEW , Uri.parse("https://youtu.be/Q6iK6DjV_iE"));
        startActivity(trailer);
    }
}