package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.google.android.material.tabs.TabLayout;

public class DetailMovieActivity extends AppCompatActivity {
    private ViewPager viewPagerLichChieu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        initView();
    }


    public void initView(){
        viewPagerLichChieu = (ViewPager)findViewById(R.id.viewPagerDetailMovie);
        viewPagerLichChieu.setAdapter(new DetailMovieApdater(getSupportFragmentManager()));
        TabLayout tabLayoutLichChieu = (TabLayout)findViewById(R.id.tabDetailMovie);
        tabLayoutLichChieu.setupWithViewPager(viewPagerLichChieu);
    }

    public void trailer(View view) {
        Intent intent=new Intent(this, TrailerActivity.class);
        startActivity(intent);
    }
}