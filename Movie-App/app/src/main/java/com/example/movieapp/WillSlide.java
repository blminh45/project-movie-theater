package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.movieapp.fragments.Will1;
import com.example.movieapp.fragments.Will2;
import com.example.movieapp.fragments.Will3;
import com.example.movieapp.fragments.Will4;
import com.example.movieapp.fragments.Will5;

import java.util.ArrayList;
import java.util.List;

public class WillSlide extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_will_slide);
        List<Fragment> list=new ArrayList<>();
        list.add(new Will1());
        list.add(new Will2());
        list.add(new Will3());
        list.add(new Will4());
        list.add(new Will5());
        pager = findViewById(R.id.WillPager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);
        this.pager.setPageTransformer(true,new ZoomOutPageTransformer());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
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

    public void ChiTietPhim(View view) {
        Intent intent = new Intent(this, DetailMovieActivity.class);
        startActivity(intent);
    }
}