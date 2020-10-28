package com.example.movieapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.movieapp.fragments.New1;
import com.example.movieapp.fragments.New2;
import com.example.movieapp.fragments.New3;
import com.example.movieapp.fragments.New4;
import com.example.movieapp.fragments.New5;

import java.util.ArrayList;
import java.util.List;

public class NowSlide extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_slide);
        List<Fragment> list=new ArrayList<>();
        list.add(new New1());
        list.add(new New2());
        list.add(new New3());
        list.add(new New4());
        list.add(new New5());
        pager = findViewById(R.id.NowPager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);
        this.pager.setPageTransformer(true,new ZoomOutPageTransformer());
    }

    public void Back(View view) {
        finish();
    }
}