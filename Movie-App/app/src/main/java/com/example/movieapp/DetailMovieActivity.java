package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class DetailMovieActivity extends AppCompatActivity {
    private ViewPager viewPagerLichChieu;
    private TextView movieName;
    private TextView movieTuoi;
    private TextView movieDiem;
    private ImageView anhDaiDien;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        //Nhận dữ liệu từ phim được click
        setDetail();
        initView();
    }

    private void setDetail(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("MovieName");
        String poster = intent.getStringExtra("MoviePoster");
        String theloai = intent.getStringExtra("MovieTheLoai");
        String diem = intent.getStringExtra("MovieDiem");
        String tuoi = intent.getStringExtra("MovieTuoi");
        Toast.makeText(this, diem, Toast.LENGTH_SHORT).show();
        movieName =(TextView)findViewById(R.id.movieName);
        movieTuoi =(TextView)findViewById(R.id.movieTuoi);
        movieDiem=(TextView)findViewById(R.id.movieDiem);
        anhDaiDien=(ImageView)findViewById(R.id.anhDaiDien);
        movieName.setText(name);
        movieDiem.setText(diem);
        movieTuoi.setText(tuoi+"+");
        int number = Integer.parseInt(poster);
        anhDaiDien.setImageResource(number);
    }



    public void initView(){
        viewPagerLichChieu = (ViewPager)findViewById(R.id.viewPagerDetailMovie);
        viewPagerLichChieu.setAdapter(new DetailMovieApdater(getSupportFragmentManager()));
        TabLayout tabLayoutLichChieu = (TabLayout)findViewById(R.id.tabDetailMovie);
        tabLayoutLichChieu.setupWithViewPager(viewPagerLichChieu);
    }

    public void trailer(View view) {
        Intent intent = new Intent(this, WatchTrailerActivity.class);
        startActivity(intent);
    }
    public void DatVe(View view) {
        Intent intent = new Intent(this, PayActivity.class);
        startActivity(intent);
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

    public void ThanhToan(View view) {
        Intent intent = new Intent(this, PayActivity.class);
        startActivity(intent);
    }

    public void OnMenu(View view) {
        Intent intent=new Intent(this,ActivityMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }
}