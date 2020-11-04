package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class DetailMovieApdater extends FragmentStatePagerAdapter {
    private String listTab[] = {"Lịch chiếu" , "Thông tin"  , "Bình luận"};
    private TabLichChieu tabLichChieu;
    private TabThongTin tabThongTin;
    private TabBinhLuan tabBinhLuan;
    public DetailMovieApdater(@NonNull FragmentManager fm) {
        super(fm);
        tabLichChieu = new TabLichChieu();
        tabThongTin = new TabThongTin();
        tabBinhLuan = new TabBinhLuan();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return tabLichChieu;
        }
        if(position == 1){
            return tabThongTin;
        }
        if(position == 2){
            return tabBinhLuan;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}
