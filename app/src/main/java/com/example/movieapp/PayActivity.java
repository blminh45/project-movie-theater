package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        setDetail();
    }

    public void OnMenu(View view) {
        Intent intent=new Intent(this,ActivityMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

//  Phú thêm phần dổ dữ liệu qua
    ImageView anhDaiDien;
    TextView txtName;
    TextView txtRap;
    TextView txtTime;
    TextView txtGhe;
    TextView txtNgay;
    TextView txtChiNhanh;
    TextView txtTongTien;


    private void setDetail(){
        Intent intent = getIntent();
        String idMovie = intent.getStringExtra("MovieID");
        String idGhe = intent.getStringExtra("IDGhe");
        String idChiNhanh = intent.getStringExtra("IDChiNhanh");
        String idRap = intent.getStringExtra("IDRap");

        String name = intent.getStringExtra("MovieName");
        String poster = intent.getStringExtra("MoviePoster");
        String rap = intent.getStringExtra("MovieRap");
        String time = intent.getStringExtra("MovieTime");
        String ghe = intent.getStringExtra("MovieGhe");
        String ngay = intent.getStringExtra("MovieNgay");
        String chinhanh = intent.getStringExtra("MovieChiNhanh");
        String GiaVe = intent.getStringExtra("TongTien");
//        int number = Integer.parseInt(poster);
        txtName =(TextView)findViewById(R.id.movieDate);
        txtRap =(TextView)findViewById(R.id.txtRap);
        txtChiNhanh =findViewById(R.id.txtChiNhanh);
        txtTime=(TextView)findViewById(R.id.textViewSuatChieu);
        txtGhe=(TextView)findViewById(R.id.textViewGhe);
        anhDaiDien=(ImageView)findViewById(R.id.imageView);
        txtTongTien=(TextView)findViewById(R.id.textViewTongTien);

        txtChiNhanh.setText(chinhanh);
        txtName.setText(name);
        txtRap.setText(rap);
        txtTime.setText(time+" - "+ ngay);
        txtGhe.setText(ghe);
        txtTongTien.setText(GiaVe);
        Picasso.get().load("http://dashboard-movie-web.herokuapp.com/images/"+poster).into(anhDaiDien);
    }
}