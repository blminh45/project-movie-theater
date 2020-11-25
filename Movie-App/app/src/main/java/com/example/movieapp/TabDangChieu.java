package com.example.movieapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class TabDangChieu extends Fragment {
    private View dangChieuRootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dangChieuRootView = inflater.inflate(R.layout.activity_tab_dang_chieu_recycler_view, container , false);
        initView(dangChieuRootView);
        return dangChieuRootView;
    }
    public void initView(View view){
        RecyclerView recyclerView =(RecyclerView)view.findViewById(R.id.recycler_dang_chieu);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<PhimDangChieu> listfive = new ArrayList<>();
        listfive.add(new PhimDangChieu(R.drawable.p12, "Đứa con thời tiết" , "Tình cảm" , "9/10" , 18));
        listfive.add(new PhimDangChieu(R.drawable.p1, "Đứa con thời tiết" , "Tình cảm" , "9/10" , 18));
        listfive.add(new PhimDangChieu(R.drawable.p2, "Đứa con thời tiết" , "Tình cảm" , "9/10" , 18));
        listfive.add(new PhimDangChieu(R.drawable.p3, "Đứa con thời tiết" , "Tình cảm" , "9/10" , 18));
        listfive.add(new PhimDangChieu(R.drawable.p4, "Đứa con thời tiết" , "Tình cảm" , "9/10" , 18));
        DangChieuAdapter dangChieuAdapter = new DangChieuAdapter(listfive, getContext());
        recyclerView.setAdapter(dangChieuAdapter);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText( getActivity() , "" + Integer.toString(listfive.get(0).getPoster()), Toast.LENGTH_SHORT).show();
//            }
//        }, 5000);

    }
}
