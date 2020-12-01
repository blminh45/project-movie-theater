package com.example.movieapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class TabSapChieu extends Fragment {
    private View sapChieuRootView;
    ArrayList<Phim> listSapChieu = new ArrayList<>();
    private RecyclerView recyclerViewSapChieu;
    private StaggeredGridLayoutManager gridLayoutManagerSapChieu;
    private SearchView field;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sapChieuRootView = inflater.inflate(R.layout.activity_tab_sap_chieu_recycler_view, container , false);
        createData();
        initView(sapChieuRootView);
        return sapChieuRootView;
    }
    public void createData(){
        listSapChieu.add(new Phim(R.drawable.p12, "Đứa con thời tiết" , "Tình cảm" , 9 , 18));
        listSapChieu.add(new Phim(R.drawable.p1, "Cục nợ hóa cục cưng" , "Tình cảm" , 8 , 18));
        listSapChieu.add(new Phim(R.drawable.p2, "Lật mặt 48H" , "Hành động" , 7 , 18));
        listSapChieu.add(new Phim(R.drawable.p3, "Em là của em" , "Tình cảm" , 6 , 18));
        listSapChieu.add(new Phim(R.drawable.p4, "Chị Mười Ba" , "Hành động" , 8 , 18));
    }
    public void initView(View view){
        recyclerViewSapChieu =(RecyclerView)view.findViewById(R.id.recycler_sap_chieu);
        recyclerViewSapChieu.setHasFixedSize(true);

        gridLayoutManagerSapChieu = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
        recyclerViewSapChieu.setLayoutManager(gridLayoutManagerSapChieu);
//        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
//        recyclerView.setLayoutManager(linearLayoutManager);
        SapChieuAdapter sapChieuAdapter = new SapChieuAdapter(listSapChieu, getContext());
        recyclerViewSapChieu.setAdapter(sapChieuAdapter);
//        showListSearch();
    }
    public void showListSearch(){
        field = (SearchView)getActivity().findViewById(R.id.search);
        field.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String getText) {
                if(getText.isEmpty()) {
                    recyclerViewSapChieu =(RecyclerView)getActivity().findViewById(R.id.recycler_sap_chieu);
                    recyclerViewSapChieu.setHasFixedSize(true);

                    gridLayoutManagerSapChieu = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
                    recyclerViewSapChieu.setLayoutManager(gridLayoutManagerSapChieu);
                    SapChieuAdapter sapChieuAdapter = new SapChieuAdapter( listSapChieu , getContext());
                    recyclerViewSapChieu.setAdapter(sapChieuAdapter);
                }
                ArrayList<Phim> resultSC = new ArrayList<>();
                int len = listSapChieu.size();
                for(int i=0;i<len;i++){
                    if(listSapChieu.get(i).getName().toLowerCase().contains(getText.toLowerCase()))
                        resultSC.add(listSapChieu.get(i));
                }

                recyclerViewSapChieu = (RecyclerView)getActivity().findViewById(R.id.recycler_sap_chieu);
                recyclerViewSapChieu.setHasFixedSize(true);
                gridLayoutManagerSapChieu = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
                recyclerViewSapChieu.setLayoutManager(gridLayoutManagerSapChieu);
                SapChieuAdapter sapChieuAdapter = new SapChieuAdapter( resultSC , getContext());
                recyclerViewSapChieu.setAdapter(sapChieuAdapter);
                return false;
            }
        });
    }

}
