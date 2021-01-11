package com.example.movieapp;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

public class TabTatCa extends Fragment {
    private View tatCaRootView;
    ArrayList<Phim> listTatCa = new ArrayList<>();
    private RecyclerView recyclerViewTatCa;
    private StaggeredGridLayoutManager gridLayoutManagerTatCa;
    private SearchView field;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tatCaRootView = inflater.inflate(R.layout.activity_tab_tat_ca_phim_recycler, container , false);
        createData();
        initView(tatCaRootView);
        return tatCaRootView;
    }
    public void createData(){
//        listTatCa.clear();
//        listTatCa.add(new Phim(R.drawable.p12, "Đứa con thời tiết tất cả" , "Tình cảm" , 9 , 18));
//        listTatCa.add(new Phim(R.drawable.p1, "Cục nợ hóa cục cưng" , "Tình cảm" , 8 , 18));
//        listTatCa.add(new Phim(R.drawable.p2, "Lật mặt 48H" , "Hành động" , 7 , 18));
//        listTatCa.add(new Phim(R.drawable.p3, "Em là của em" , "Tình cảm" , 6 , 18));
//        listTatCa.add(new Phim(R.drawable.p4, "Chị Mười Ba" , "Hành động" , 8 , 18));
        String jSonString = null;
        try{
            jSonString = new APIGetting(getActivity()).execute(new Phim()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        get_list_word(jSonString);
    }
    private void get_list_word(String jSonString){
        try{
            listTatCa = new ArrayList<>();
            JSONArray jr=  new JSONArray(jSonString);
            int len = jr.length();
            for(int i= 0 ; i<len;i++){
                JSONObject jb = (JSONObject) jr .getJSONObject(i);
                Phim phim = new Phim();
                phim.setName(jb.getString("ten_phim"));
                phim.setPoster(jb.getString("hinh_anh"));
                phim.setDiem(9);
                phim.setTuoi(18);
                phim.setTheLoai(jb.getString("id_the_loai"));
                listTatCa.add(phim);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void initView(View view){
        recyclerViewTatCa =(RecyclerView)view.findViewById(R.id.recycler_tat_ca);
        recyclerViewTatCa.setHasFixedSize(true);

        gridLayoutManagerTatCa = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
        recyclerViewTatCa.setLayoutManager(gridLayoutManagerTatCa);
        TatCaAdapter tatCaAdapter = new TatCaAdapter(listTatCa, getContext());
        recyclerViewTatCa.setAdapter(tatCaAdapter);
        showListSearch();
    }
    public void showListSearch(){
        field = (SearchView)tatCaRootView.findViewById(R.id.searchTatCa);
        field.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String getText) {
                if(getText.isEmpty()) {
                    recyclerViewTatCa =(RecyclerView)getActivity().findViewById(R.id.recycler_tat_ca);
                    recyclerViewTatCa.setHasFixedSize(true);

                    gridLayoutManagerTatCa = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
                    recyclerViewTatCa.setLayoutManager(gridLayoutManagerTatCa);
                    TatCaAdapter tatCaAdapter = new TatCaAdapter( listTatCa , getContext());
                    recyclerViewTatCa.setAdapter(tatCaAdapter);
                }
                ArrayList<Phim> result = new ArrayList<>();
                int len = listTatCa.size();
                for(int i=0;i<len;i++){
                    if(listTatCa.get(i).getName().toLowerCase().contains(getText.toLowerCase()))
                        result.add(listTatCa.get(i));
                }

                recyclerViewTatCa = (RecyclerView)getActivity().findViewById(R.id.recycler_tat_ca);
                recyclerViewTatCa.setHasFixedSize(true);
                gridLayoutManagerTatCa = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
                recyclerViewTatCa.setLayoutManager(gridLayoutManagerTatCa);
                TatCaAdapter tatCaAdapter = new TatCaAdapter( result , getContext());
                recyclerViewTatCa.setAdapter(tatCaAdapter);
                return false;
            }
        });
    }
}
