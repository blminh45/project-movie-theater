package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static android.app.Activity.RESULT_OK;
public class TabLichChieu extends Fragment {
    private View lichChieuRootView;
    GridView GioChieu;
    GridView NgayChieu;
    TextView idlich;
    private Spinner spinnerChiNhanh;
    private Spinner spinnerRap;



//    private  ArrayList<ChiNhanh> ListChiNhanh =new ArrayList<>();
//    private  ArrayList<Rap> ListRap = new ArrayList<>();


    private List<String> listchinhanh = new ArrayList<>();
    private  List<String> listrap = new ArrayList<>();
    private  List<String> DanhSachGio = new ArrayList<>();
    private List<String> DanhSachNgay = new ArrayList<>();
    private List<String> IDLich = new ArrayList<>();
//    String[] DanhSachGio = {"09:00","12:00","15:00","18:00","21:00"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lichChieuRootView = inflater.inflate(R.layout.activity_tab_lich_chieu, container , false);
        showThongTin();
        showGridView();

        return lichChieuRootView;

    }
    public void showGridView(){

        GioChieu = lichChieuRootView.findViewById(R.id.GioChieu);

        ArrayAdapter adapter = new ArrayAdapter(
                getActivity(), android.R.layout.simple_list_item_1 ,DanhSachGio
        );


        GioChieu.setAdapter(adapter);
        //Thêm sự kiên click
        GioChieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText( getActivity() , "" + DanhSachGio[position], Toast.LENGTH_SHORT).show();
                TextView time = (TextView)lichChieuRootView.findViewById(R.id.actived_time);
                TextView ghe = (TextView)lichChieuRootView.findViewById(R.id.actived_chair);
                time.setText(" "+DanhSachGio.get(position)+" ");
                ghe.setText("--");
            }
        });

        NgayChieu = lichChieuRootView.findViewById(R.id.NgayChieu);

        ArrayAdapter adapter1 = new ArrayAdapter(
                getActivity(), android.R.layout.simple_list_item_1 ,DanhSachNgay
        );


        NgayChieu.setAdapter(adapter1);
        //Thêm sự kiên click
        NgayChieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText( getActivity() , "" + DanhSachGio[position], Toast.LENGTH_SHORT).show();
                TextView ngay = (TextView)lichChieuRootView.findViewById(R.id.txtNgayChieu);
                ngay.setText(" "+DanhSachNgay.get(position)+" ");
            }
        });

        idlich = (TextView)lichChieuRootView.findViewById(R.id.idLich);
        idlich.setText(IDLich.get(0));
    }
    public void showThongTin(){
        String jSonString = null;
        try{
            jSonString = new LichChieuAPIGetting(getActivity()).execute(new LichChieu()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        get_list_thong_tin(jSonString);

        spinnerChiNhanh = lichChieuRootView.findViewById(R.id.ThanhPho);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, listchinhanh);
        spinnerChiNhanh.setAdapter(spinnerAdapter);
        spinnerRap = lichChieuRootView.findViewById(R.id.Rap);
        ArrayAdapter spinnerAdapterRap = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, listrap);
        spinnerRap.setAdapter(spinnerAdapterRap);
    }
    private void get_list_thong_tin(String jSonString){
        try{
            listchinhanh = new ArrayList<>();
            listrap = new ArrayList<>();
            JSONArray jr=  new JSONArray(jSonString);
            int len = jr.length();
            for(int i= 0 ; i<len;i++){
                JSONObject jb = (JSONObject) jr .getJSONObject(i);
                if(DetailMovieActivity.phimTruyen.getIDPhim()==Integer.parseInt(jb.getString("id_phim"))){
                    listchinhanh.add(jb.getString("ten_chi_nhanh"));
                    listrap.add(jb.getString("id_rap") + "-" + jb.getString("ten_rap"));
                    DanhSachGio.add(jb.getString("gio_chieu"));
                    DanhSachNgay.add(jb.getString("ngay_chieu"));
                    IDLich.add(jb.getString("id"));
                    int a= 2;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
