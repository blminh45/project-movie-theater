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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class TabDangChieu extends Fragment {
    private View dangChieuRootView;
    ArrayList<Phim> listDangChieu = new ArrayList<>();
    private RecyclerView recyclerViewDangChieu;
    private StaggeredGridLayoutManager gridLayoutManagerDangChieu;
    private SearchView field;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dangChieuRootView = inflater.inflate(R.layout.activity_tab_dang_chieu_recycler_view, container , false);
        recyclerViewDangChieu =(RecyclerView)dangChieuRootView.findViewById(R.id.recycler_dang_chieu);
        createData();
        initView(dangChieuRootView,listDangChieu);
        return dangChieuRootView;
    }
    public void createData(){
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
            listDangChieu = new ArrayList<>();
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
                listDangChieu.add(phim);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void initView(View view,ArrayList<Phim> listSapChieu){
        initRecyclerView(listSapChieu);
        showListSearch(listSapChieu);
    }
    public void showListSearch( ArrayList<Phim> listDangChieu){
        field = (SearchView)dangChieuRootView.findViewById(R.id.searchDangChieu);
        field.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String getText) {
                if(getText.isEmpty()) {
                    initRecyclerView(listDangChieu);
                }
                ArrayList<Phim> resultSC = new ArrayList<>();
                int len = listDangChieu.size();
                for(int i=0;i<len;i++){
                    if(listDangChieu.get(i).getName().toLowerCase().contains(getText.toLowerCase()))
                        resultSC.add(listDangChieu.get(i));
                }

                initRecyclerView(resultSC);
                return false;
            }
        });
    }
    public  void initRecyclerView(ArrayList<Phim> lst)
    {
        recyclerViewDangChieu.setHasFixedSize(true);
        gridLayoutManagerDangChieu = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
        recyclerViewDangChieu.setLayoutManager(gridLayoutManagerDangChieu);
        TatCaAdapter sapChieuAdapter = new TatCaAdapter( lst , getContext());
        recyclerViewDangChieu.setAdapter(sapChieuAdapter);
    }
}
