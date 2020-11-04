package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class ListMovieActivity extends AppCompatActivity {
    private ViewPager viewPagerDangChieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        initView();
    }
    public void initView(){
        viewPagerDangChieu = (ViewPager)findViewById(R.id.viewPagerListMovie);
        viewPagerDangChieu.setAdapter(new ListMovieApdater(getSupportFragmentManager()));
        TabLayout tabLayoutDangChieu = (TabLayout)findViewById(R.id.tabListMovie);
        tabLayoutDangChieu.setupWithViewPager(viewPagerDangChieu);
    }

    public void Detail(View view) {
        Intent intent=new Intent(this,DetailMovieActivity.class);
        startActivity(intent);
    }
}