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
import java.util.List;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class TabLichChieu extends Fragment {
    private View lichChieuRootView;
    GridView GioChieu;
    private Spinner spinnerThanhPho;
    private Spinner spinnerRap;
    private  List<String> listThanhPho;
    private  List<String> listRap;
    String[] DanhSachGio = {"09:45","10:45","11:45","12:45","1:45","2:45","4:45","6:45","8:45","22:45","09:45","10:45","09:45","10:45","09:45","10:45",};
//    String selectedItem;
//    TextView GridViewItems,BackSelectedItem;
//    int backposition = -1;
//    int count = 0;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lichChieuRootView = inflater.inflate(R.layout.activity_tab_lich_chieu, container , false);
        showGridView();
        showThanhPho();
        showRap();
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
                time.setText(" "+DanhSachGio[position]+" ");
//                selectedItem = parent.getItemAtPosition(position).toString();
//
//                GridViewItems = (TextView) view;
//
//
//                if(count==0){
//                    GridViewItems.setBackgroundColor(Color.parseColor("#00BCD4"));
//                    GridViewItems.setTextColor(Color.parseColor("#fdfcfa"));
//                    BackSelectedItem = (TextView) GioChieu.getChildAt(backposition);
//                    count = 1;
//                }
//                else {
//                    GridViewItems.setBackgroundColor(Color.parseColor("#FFFFFF"));
//                    GridViewItems.setTextColor(Color.parseColor("#000000"));
//                    BackSelectedItem = (TextView) GioChieu.getChildAt(backposition);
//                    count = 0;
//                }
            }
        });
    }
    public void showThanhPho(){
        listThanhPho = new ArrayList<>();
        listThanhPho.add("TP Hồ Chí Minh");
        listThanhPho.add("Hà Nội");
        listThanhPho.add("Bình Thuận");
        listThanhPho.add("Bến Tre");
        spinnerThanhPho = lichChieuRootView.findViewById(R.id.ThanhPho);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, listThanhPho);

        spinnerThanhPho.setAdapter(spinnerAdapter);
    }

    public void showRap(){
        listRap = new ArrayList<>();
        listRap.add("Galaxy Nguyễn Du");
        listRap.add("Galaxy Tân Bình");
        listRap.add("Galaxy Kinh Dương Vương");
        listRap.add("Galaxy Quang Trung");
        spinnerRap = lichChieuRootView.findViewById(R.id.Rap);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, listRap);
        spinnerRap.setAdapter(spinnerAdapter);
    }

}