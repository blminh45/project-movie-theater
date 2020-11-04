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
    private ViewPager viewPagerDangChieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_login:
                Intent intent1=new Intent(this,LoginActivity.class);
                startActivity(intent1);;
                return true;
            case R.id.action_signup:
                Intent intent2=new Intent(this,SignUpActivity.class);
                startActivity(intent2);;
                return true;
            case R.id.action_list:
                Intent intent3=new Intent(this,ListMovieActivity.class);
                startActivity(intent3);;
                return true;
            case R.id.action_profile:
                Intent intent4=new Intent(this,ProfileActivity.class);
                startActivity(intent4);
                return true;

            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}