package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.*;

public class TabDangChieu extends Fragment {
    private View dangChieuRootView;
    ArrayList<Phim> listfive = new ArrayList<>();
    private RecyclerView recyclerView;
    private  LinearLayoutManager linearLayoutManager;
    private StaggeredGridLayoutManager gridLayoutManager;
    private DangChieuAdapter dangChieuAdapter;
    private ListMovieActivity listMovieActivity;
    private SearchView field;


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
        showListSearch();
    }

    public void showListSearch(){
        field = (SearchView)dangChieuRootView.findViewById(R.id.searchDangChieu);
        field.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String getText) {
                if(getText.isEmpty()) {
                    recyclerView =(RecyclerView)getActivity().findViewById(R.id.recycler_dang_chieu);
                    recyclerView.setHasFixedSize(true);

                    gridLayoutManager = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    DangChieuAdapter dangChieuAdapter = new DangChieuAdapter(listfive, getContext());
                    recyclerView.setAdapter(dangChieuAdapter);
                }
                ArrayList<Phim> result = new ArrayList<>();
                int len = listfive.size();
                 for(int i=0;i<len;i++){
                     if(listfive.get(i).getName().toLowerCase().contains(getText.toLowerCase()))
                         result.add(listfive.get(i));
                 }

            recyclerView = (RecyclerView)getActivity().findViewById(R.id.recycler_dang_chieu);
            recyclerView.setHasFixedSize(true);
            gridLayoutManager = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(gridLayoutManager);
            DangChieuAdapter dangChieuAdapter = new DangChieuAdapter( result , getContext());
            recyclerView.setAdapter(dangChieuAdapter);
                return false;
            }
        });
    }


    //        field.addTextChangedListener(new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//            String getText = ((EditText)listMovieActivity.findViewById(R.id.search)).getText().toString();
//            if(getText.isEmpty()) {
//                recyclerView =(RecyclerView)listMovieActivity.findViewById(R.id.recycler_dang_chieu);
//                recyclerView.setHasFixedSize(true);
//
//                gridLayoutManager = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
//                recyclerView.setLayoutManager(gridLayoutManager);
////        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
////        recyclerView.setLayoutManager(linearLayoutManager);
//                DangChieuAdapter dangChieuAdapter = new DangChieuAdapter(listfive, getContext());
//                recyclerView.setAdapter(dangChieuAdapter);
//            }
//            ArrayList<Phim> result = new ArrayList<>();
//            int len = listfive.size();
//            for(int j=0;j<len;j++){
//                if(listfive.get(i).getName().toLowerCase().contains(getText.toLowerCase()))
//                    result.add(listfive.get(i));
//            }
//
//            recyclerView = (RecyclerView)getActivity().findViewById(R.id.recycler_dang_chieu);
//            recyclerView.setHasFixedSize(true);
//            gridLayoutManager = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
//            recyclerView.setLayoutManager(gridLayoutManager);
//            DangChieuAdapter dangChieuAdapter = new DangChieuAdapter( result , getContext());
//            recyclerView.setAdapter(dangChieuAdapter);
//        }
//    });
//    FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent=new Intent(context,NoteMag.class);
//            startActivity(intent);
//
//        }
//    });
}
