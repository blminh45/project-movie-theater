package com.example.movieapp;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {
    private List<String> listimg = new ArrayList<>();
    private RecyclerView mRecylerView;
    private MainAdapter mAdapter;

    private RecyclerView mRecylerView2;
    private MainAdapter mAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createData();
        mRecylerView = findViewById(R.id.recycler_main);
        mAdapter = new MainAdapter(listimg, this);
        mRecylerView.setAdapter(mAdapter);
        mRecylerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        mRecylerView2 = findViewById(R.id.recycler_main2);
        mAdapter2 = new MainAdapter(listimg, this);
        mRecylerView2.setAdapter(mAdapter2);
        mRecylerView2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
    }

    public void createData(){
        String jSonString = null;
        try{
            jSonString = new APIGetting(this).execute(new Phim()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        get_list_phim(jSonString);
    }
    private void get_list_phim(String jSonString){
        try{
            JSONArray jr=  new JSONArray(jSonString);
            int len = jr.length();
            for(int i= 0 ; i<len;i++){
                JSONObject jb = (JSONObject) jr .getJSONObject(i);
                if(Integer.parseInt(jb.getString("trang_thai"))==1){
                    listimg.add(jb.getString("hinh_anh"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void NowSlide(View view) {
        Intent intent=new Intent(this,NowSlide.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }
    public void WillSlide(View view) {
        Intent intent=new Intent(this,WillSlide.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }


    public void OnMenu(View view) {
        Intent intent=new Intent(this,ActivityMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }


    public void ToList(View view) {
        Intent intent=new Intent(this,ListMovieActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    public void ToUser(View view) {
        Intent intent=new Intent(this,InforActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    public void DangChieu(View view) {
        Intent intent=new Intent(this,NowSlide.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    public void SapChieu(View view) {
        Intent intent=new Intent(this,WillSlide.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }
}