package com.example.movieapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.*;

public class TabDangChieu extends Fragment {
    private View dangChieuRootView;
    ArrayList<Phim> listfive = new ArrayList<>();
    private RecyclerView recyclerView;
    private  LinearLayoutManager linearLayoutManager;
    private StaggeredGridLayoutManager gridLayoutManager;
    private DangChieuAdapter dangChieuAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dangChieuRootView = inflater.inflate(R.layout.activity_tab_dang_chieu_recycler_view, container , false);
        createData();
        initView(dangChieuRootView);
        return dangChieuRootView;
    }
    public void createData(){
        listfive.add(new Phim(R.drawable.p12, "Đứa con thời tiết" , "Tình cảm" , 9 , 18));
        listfive.add(new Phim(R.drawable.p1, "Cục nợ hóa cục cưng" , "Tình cảm" , 8 , 18));
        listfive.add(new Phim(R.drawable.p2, "Lật mặt 48H" , "Hành động" , 7 , 18));
        listfive.add(new Phim(R.drawable.p3, "Em là của em" , "Tình cảm" , 6 , 18));
        listfive.add(new Phim(R.drawable.p4, "Chị Mười Ba" , "Hành động" , 8 , 18));
    }
    public void initView(View view){
        recyclerView =(RecyclerView)view.findViewById(R.id.recycler_dang_chieu);
        recyclerView.setHasFixedSize(true);

        gridLayoutManager = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
//        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
//        recyclerView.setLayoutManager(linearLayoutManager);
        DangChieuAdapter dangChieuAdapter = new DangChieuAdapter(listfive, getContext());
        recyclerView.setAdapter(dangChieuAdapter);
    }
}
