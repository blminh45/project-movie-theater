package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.google.android.material.tabs.TabLayout;

public class ListMovieActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ViewPager viewPager;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        initView();
    }
    public void initView(){
        viewPager = (ViewPager)findViewById(R.id.viewPagerListMovie);
        viewPager.setAdapter(new ListMovieApdater(getSupportFragmentManager()));
        TabLayout tabLayoutDangChieu = (TabLayout)findViewById(R.id.tabListMovie);
        tabLayoutDangChieu.setupWithViewPager(viewPager);
    }

    public void Detail(View view) {
        Intent intent=new Intent(this,DetailMovieActivity.class);
        startActivity(intent);
    }

    public void filter(View view) {
        PopupMenu filter = new PopupMenu(this,view);
        filter.setOnMenuItemClickListener(this);
        filter.inflate(R.menu.popup_menu_filter);
        filter.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return true;
    }


    public void OnMenu(View view) {
        Intent intent=new Intent(this,ActivityMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }
}