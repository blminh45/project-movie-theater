package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class ChooseChairActivity extends AppCompatActivity {
//Truyen du lieu
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private String mReply = "";
    private GridView Chair;
    private  ArrayList<Ghe> listGhe;
    private String[] DanhSachGhe;
    private TextView ShowGheChon ;
    String selectedItem;
    TextView GridViewItems,BackSelectedItem;
    int backposition = -1;
    int count = 0;
    int[] vitri = new int[30];
    int ivitri=0;
    Ghe gheClick  = new Ghe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_chair);
        String jSonString = null;
        vitri[ivitri]=-1;
        try{
            jSonString = new GheAPIGetting(this).execute(new Ghe()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try{
            listGhe = new ArrayList<>();
            JSONArray jr=  new JSONArray(jSonString);
            int len = jr.length();
            DanhSachGhe = new String[len];
            for(int i= 0 ; i<len;i++){
                JSONObject jb = (JSONObject) jr .getJSONObject(i);
                Ghe ghe = new Ghe();
                ghe.setHang(jb.getString("hang"));
                ghe.setCot(Integer.parseInt(jb.getString("cot")));
                ghe.setTrangThai(Integer.parseInt(jb.getString("trang_thai")));
                ghe.setGiaGhe(Double.parseDouble(jb.getString("gia_ghe")));
                listGhe.add(ghe);
                if(ghe.getTrangThai() == 0){
                    DanhSachGhe[i]= ghe.getHang()+ghe.getCot()+"*";
                    vitri[ivitri] = i;
                    ivitri++;
                }
                else{
                    DanhSachGhe[i]= ghe.getHang()+ghe.getCot();
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        showGridView();
    }
    public void showGridView(){
        Chair = (GridView)findViewById(R.id.Chair);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,DanhSachGhe){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                for(int i=0; i<vitri.length; i++)
                if(position == vitri[i] && vitri[0]!=-1){
                    view.setBackgroundColor(Color.parseColor("#00BCD4"));
                }
                return view;
            }
        };
        Chair.setAdapter(adapter);

//        Thêm sự kiên click
        Chair.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ChooseChairActivity.this , DanhSachGhe[position] , Toast.LENGTH_SHORT).show();
                mReply = DanhSachGhe[position];
                if(mReply.contains("*")){
                    Toast.makeText(ChooseChairActivity.this, "Ghế đã được chọn", Toast.LENGTH_SHORT).show();
                }
                else {
                    gheClick =  listGhe.get(position);
                    ShowGheChon = findViewById(R.id.txtChonGhe);
                    ShowGheChon.setText("  "+mReply+"  ");
                }
//                selectedItem = parent.getItemAtPosition(position).toString();
//                GridViewItems = (TextView) view;
//
//                if(count==0){
//                    GridViewItems.setBackgroundColor(Color.parseColor("#00BCD4"));
//                    GridViewItems.setTextColor(Color.parseColor("#fdfcfa"));
//                    BackSelectedItem = (TextView) Chair.getChildAt(backposition);
//                    count = 1;
//                }
//                else {
//                    GridViewItems.setBackgroundColor(Color.parseColor("#FFFFFF"));
//                    GridViewItems.setTextColor(Color.parseColor("#000000"));
//                    BackSelectedItem = (TextView) Chair.getChildAt(backposition);
//                    count = 0;
//                }
            }
        });
    }

    public void Chon(View view) {

        String intentGhe = gheClick.getHang()+"-"+gheClick.getCot()+"-"+gheClick.getGiaGhe()+"-"+gheClick.getTrangThai();
        String reply = mReply;
        if(!reply.equals("")){
            Intent replyIntent = new Intent();
            replyIntent.putExtra(EXTRA_REPLY, intentGhe);
            setResult(RESULT_OK, replyIntent);

            finish();
        }
        else{
            Toast.makeText(this, "Vui lòng chọn ghế", Toast.LENGTH_SHORT).show();
        }

    }
}