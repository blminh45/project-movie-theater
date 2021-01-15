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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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
        recyclerViewSapChieu =(RecyclerView)sapChieuRootView.findViewById(R.id.recycler_sap_chieu);
        createData();

        initView(sapChieuRootView,listSapChieu);
        return sapChieuRootView;
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
        get_list_phim(jSonString);
    }
    private void get_list_phim(String jSonString){
        try{
            listSapChieu = new ArrayList<>();
            JSONArray jr=  new JSONArray(jSonString);
            int len = jr.length();
            for(int i= 0 ; i<len;i++){
                JSONObject jb = (JSONObject) jr .getJSONObject(i);
                Phim phim = new Phim();
                phim.setIDPhim(Integer.parseInt(jb.getString("id")));
                phim.setName(jb.getString("ten_phim"));
                phim.setPoster(jb.getString("hinh_anh"));
                phim.setDiem(Float.parseFloat(jb.getString("diem")));
                phim.setTuoi(Integer.parseInt(jb.getString("tuoi")));
                phim.setTheLoai(jb.getString("id_the_loai"));
                phim.setThoiluong(jb.getString("thoi_luong"));
                phim.setKhoichieu(jb.getString("khoi_chieu"));
                phim.setTomtat(jb.getString("tom_tat"));
                phim.setTrailer(jb.getString("trailer"));
                phim.setTrangThai(Integer.parseInt(jb.getString("trang_thai")));
                if(Integer.parseInt(jb.getString("trang_thai"))==0) {
                    listSapChieu.add(phim);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void initView(View view,ArrayList<Phim> listSapChieu){
        initRecyclerView(listSapChieu);
        showListSearch(listSapChieu);
    }
    public void showListSearch( ArrayList<Phim> listSapChieu){
        field = (SearchView)sapChieuRootView.findViewById(R.id.searchSapChieu);
        field.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String getText) {
                if(getText.isEmpty()) {
                    initRecyclerView(listSapChieu);
                }
                ArrayList<Phim> resultSC = new ArrayList<>();
                int len = listSapChieu.size();
                for(int i=0;i<len;i++){
                    if(listSapChieu.get(i).getName().toLowerCase().contains(getText.toLowerCase()))
                        resultSC.add(listSapChieu.get(i));
                }

                initRecyclerView(resultSC);
                return false;
            }
        });
    }
    public  void initRecyclerView(ArrayList<Phim> lst)
    {
        recyclerViewSapChieu.setHasFixedSize(true);
        gridLayoutManagerSapChieu = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
        recyclerViewSapChieu.setLayoutManager(gridLayoutManagerSapChieu);
        TatCaAdapter sapChieuAdapter = new TatCaAdapter( lst , getContext());
        recyclerViewSapChieu.setAdapter(sapChieuAdapter);
    }
}
