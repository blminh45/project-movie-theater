package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import java.util.*;

public class ChooseChairActivity extends AppCompatActivity {
    GridView Chair;
    String[] DanhSachGhe = {"A1","A2","A3","A4","A5","A6","A7","A8","B1","B2","B3","B4","B5","B6","B7","B8",
            "C1","C2","C3","C4","C5","C6","C7","C8","D1","D2","D3","D4","D5","D6","D7","D8",
            "E1","E2","E3","E4","E5","E6","E7","E8","F1","F2","F3","F4","F5","F6","F7","F8",
            "G1","G2","G3","G4","G5","G6","G7","G8","H1","H2","H3","H4","H5","H6","H7","H8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_chair);
    }
    public void showGridView(){

        Chair = (GridView)findViewById(R.id.Chair);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,DanhSachGhe);
        Chair.setAdapter(adapter);
        //Thêm sự kiên click
//        Chair.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(this, "" + DanhSachGhe[position], Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}