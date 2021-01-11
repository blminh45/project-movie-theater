package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class ChooseChairActivity extends AppCompatActivity {
//Truyen du lieu
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private String mReply = "";
    private GridView Chair;
    private String[] DanhSachGhe = {"A1","A2","A3","A4","A5","A6","B1","B2","B3","B4","B5","B6",
            "C1","C2","C3","C4","C5","C6","D1","D2","D3","D4","D5","D6",
            "E1","E2","E3","E4","E5","E6","F1","F2","F3","F4","F5","F6",
            "G1","G2","G3","G4","G5","G6","H1","H2","H3","H4","H5","H6","A1","A2","A3","A4","A5","A6","A1","A2","A3","A4","A5","A6","A1","A2","A3","A4","A5","A6","A1","A2","A3","A4","A5","A6"};

    String selectedItem;
    TextView GridViewItems,BackSelectedItem;
    int backposition = -1;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_chair);
        showGridView();
    }
    public void showGridView(){

        Chair = (GridView)findViewById(R.id.Chair);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,DanhSachGhe);
        Chair.setAdapter(adapter);
//        Thêm sự kiên click
        Chair.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ChooseChairActivity.this , DanhSachGhe[position] , Toast.LENGTH_SHORT).show();
                mReply = DanhSachGhe[position];
                selectedItem = parent.getItemAtPosition(position).toString();
                GridViewItems = (TextView) view;
                int vitri = position;


                if(count==0){
                    GridViewItems.setBackgroundColor(Color.parseColor("#00BCD4"));
                    GridViewItems.setTextColor(Color.parseColor("#fdfcfa"));
                    BackSelectedItem = (TextView) Chair.getChildAt(backposition);
                    count = 1;
                }
                else {
                    GridViewItems.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    GridViewItems.setTextColor(Color.parseColor("#000000"));
                    BackSelectedItem = (TextView) Chair.getChildAt(backposition);
                    count = 0;
                }
            }
        });
    }

    public void Chon(View view) {
        String reply = mReply;
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}