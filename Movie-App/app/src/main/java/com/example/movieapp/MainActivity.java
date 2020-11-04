package com.example.movieapp;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Intent intent4=new Intent(this,InforActivity.class);
                startActivity(intent4);
                return true;

            default:
        }
        return super.onOptionsItemSelected(item);
    }


    public void NowSlide(View view) {
        Intent intent=new Intent(this,NowSlide.class);
        startActivity(intent);
    }
    public void WillSlide(View view) {
        Intent intent=new Intent(this,WillSlide.class);
        startActivity(intent);
    }



}