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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView movieName;
    private TextView movieTuoi;
    private TextView movieDiem;
    private ImageView anhDaiDien;
    private TextView movieThoiLuong;
    private TextView movieKhoiChieu;
    private String Choosed="";
    private double GiaGio= 0;
    private double GiaGhe= 0;
    private double GiaPhim=0;
    private Ghe gheNhan = new Ghe() ;

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

        Phim phim = (Phim) intent.getSerializableExtra("PhimClick");
        movieName =(TextView)findViewById(R.id.movieName);
        movieTuoi =(TextView)findViewById(R.id.movieTuoi);
        movieDiem=(TextView)findViewById(R.id.movieDiem);
        anhDaiDien=(ImageView)findViewById(R.id.anhDaiDien);
        movieThoiLuong = findViewById(R.id.thoiluong_dt);
        movieKhoiChieu = findViewById(R.id.movieDate);

        movieName.setText(phim.getName());
        movieDiem.setText(" "+Float.toString(phim.getDiem())+" ");
        movieTuoi.setText((phim.getTuoi())+"+");
        movieKhoiChieu.setText(" "+phim.getKhoichieu()+" ");
        movieThoiLuong.setText(" "+phim.getThoiluong()+" Phút ");
//        anhDaiDien.setImageResource(number);
        Picasso.get().load("http://dashboard-movie-web.herokuapp.com/images/"+phim.getPoster()).into(anhDaiDien);
    }



    public void initView(){
        viewPager = (ViewPager)findViewById(R.id.viewPagerDetailMovie);
        viewPager.setAdapter(new DetailMovieApdater(getSupportFragmentManager()));
        TabLayout tabLayoutLichChieu = (TabLayout)findViewById(R.id.tabDetailMovie);
        tabLayoutLichChieu.setupWithViewPager(viewPager);
    }

    public void trailer(View view) {
        Intent intent = getIntent();
        Phim phim = (Phim) intent.getSerializableExtra("PhimClick");

        Intent intenttrailer = new Intent(this, WatchTrailerActivity.class);
        intenttrailer.putExtra("Trailer", phim.getTrailer());

        startActivity(intenttrailer);
    }
    public void DatVe(View view) {
        Intent intent = new Intent(this, PayActivity.class);
        startActivity(intent);
    }


    public void ThanhToan(View view) {
        Intent intentphim = getIntent();
        Phim phim = (Phim) intentphim.getSerializableExtra("PhimClick");

        TextView txtName = (TextView)findViewById(R.id.movieName) ;
        TextView txtTime = (TextView)findViewById(R.id.actived_time) ;
        TextView txtNgay = (TextView)findViewById(R.id.movieDate);
        TextView txtGhe = (TextView)findViewById(R.id.actived_chair);
        Spinner Snrap = (Spinner) findViewById(R.id.Rap);
        String rap = Snrap.getSelectedItem().toString();
        Spinner Snchinhanh = (Spinner) findViewById(R.id.ThanhPho);
        String chinhanh = Snchinhanh.getSelectedItem().toString();

        String iTime = txtTime.getText().toString();
        String iGhe = txtGhe.getText().toString();
        String iNgay = txtNgay.getText().toString();
        String name = txtName.getText().toString();
        if(iTime.equals(" 09:00 ")|| iTime.equals(" 12:00 ")){
            GiaGio = 20.0;
        }
        if(iTime.equals(" 15:00 ")|| iTime.equals(" 18:00 ")){
            GiaGio = 30.0;
        }
        if(iTime.equals(" 21:00 ")){
            GiaGio = 40.0;
        }

        if(iTime.equals("")||iTime.equals(null)){
            Toast.makeText(this, "Vui lòng chọn giờ", Toast.LENGTH_SHORT).show();
        }
        else if(iGhe.equals("--")||iGhe.equals(null)||iGhe.equals("")){
            Toast.makeText(this, "Vui lòng chọn ghế", Toast.LENGTH_SHORT).show();
        }
        else if(!Choosed.equals(iTime)){
            Toast.makeText(this, "Vui lòng chọn lại ghế", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, PayActivity.class);
            intent.putExtra("MovieName", name);
            intent.putExtra("MoviePoster", phim.getPoster());
            intent.putExtra("MovieRap", rap);
            intent.putExtra("MovieChiNhanh" , chinhanh);
            intent.putExtra("MovieTime", iTime);
            intent.putExtra("MovieGhe", iGhe);
            intent.putExtra("MovieNgay", iNgay);

            GiaPhim =phim.getGia();
            GiaGhe = gheNhan.getGiaGhe();
            double TongTien  = GiaGhe + GiaPhim + GiaGio;

            intent.putExtra("TongTien", Double.toString(TongTien));
//            intent.putExtra("MovieMoney", phim.getGia());
//            intent.putExtra("GheMoney", gheNhan.getGiaGhe());
//            intent.putExtra("GioMoney", gheNhan.getGiaGhe());
            startActivity(intent);
        }
    }

    public void OnMenu(View view) {
        Intent intent=new Intent(this,ActivityMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }


    //Truyen Ghe
    public static final int TEXT_REQUEST = 1;

    public void chair(View view) {
        TextView txtTime = (TextView)findViewById(R.id.actived_time) ;
        String iTime = txtTime.getText().toString();
        Choosed = iTime;
        if(!iTime.equals("")){
            Intent intent = new Intent(this, ChooseChairActivity.class);
            startActivityForResult(intent, TEXT_REQUEST);
        }
        else{
            Toast.makeText(this, "Vui lòng chọn giờ", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        TextView txtGhe = (TextView)findViewById(R.id.actived_chair);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(ChooseChairActivity.EXTRA_REPLY);

                String[] items = reply.split("-");
                gheNhan.setHang(items[0]);
                gheNhan.setCot(Integer.parseInt(items[1]));
                gheNhan.setGiaGhe(Double.parseDouble(items[2]));
                gheNhan.setTrangThai(Integer.parseInt(items[3]));

                    txtGhe.setText(" "+items[0]+items[1]+" ");
            }
        }

    }
}