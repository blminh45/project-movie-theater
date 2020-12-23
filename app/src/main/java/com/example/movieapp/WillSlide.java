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
    }





    public void OnMenu(View view) {
        Intent intent=new Intent(this,ActivityMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    public void DanhSachPhim(View view) {
        Intent intent=new Intent(this,ListMovieActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }
}