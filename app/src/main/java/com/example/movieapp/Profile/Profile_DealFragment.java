package com.example.movieapp.Profile;

import android.os.Bundle;
import android.util.Half;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.HoaDon;
import com.example.movieapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

public class Profile_DealFragment extends Fragment {

    private View mRootView;
    ArrayList<HoaDon> lst_hd=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private HoaDonAdapter mAdapter;
    public LinkedList<HoaDon> mWordList = new LinkedList<HoaDon>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_profile_deal, container, false);
        
        String jSonString = null;
        try {
            jSonString = new APIHoaDonGetting(getContext()).execute(new HoaDon()).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        if(get_lst_hd(jSonString)){
            mWordList = convertToList(lst_hd);
            Log.d("demo",mWordList.getFirst().toString());
        }
        mRecyclerView = mRootView.findViewById(R.id.recyclerView);
        mAdapter = new HoaDonAdapter(lst_hd,getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return mRootView;
    }

    private boolean get_lst_hd(String jSonString) {
        try {
            lst_hd = new ArrayList();
            JSONArray jr = new JSONArray(jSonString);
            int num = jr.length();
            for (int i = 0; i < num; i++) {
                JSONObject jb = (JSONObject) jr.getJSONObject(i);
                HoaDon hd  = new HoaDon();
                hd.setTenPhim(jb.getString("ten"));
//                hd.setThoiLuong(jb.getDouble("ThoiLuong"));
//                hd.setRap(jb.getString("Phim"));
//                hd.setGhe(jb.getString("Phim"));
//                hd.setNgayChieu(jb.getString("Phim"));
//                hd.setGioChieu(jb.getString("Phim"));
                hd.setDiaChi(jb.getString("dia_chi"));
                lst_hd.add(hd);
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
    private LinkedList<HoaDon> convertToList(ArrayList<HoaDon> arr_hd) {
        LinkedList<HoaDon> lst_hd = new LinkedList<HoaDon>();
        for (HoaDon hoadon : arr_hd) {
            lst_hd.addLast(hoadon);
        }
        return lst_hd;
    }
}
