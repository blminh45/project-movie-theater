package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ListMovieApdater extends FragmentStatePagerAdapter {
    private String listTab[] = {"Tất cả","Đang chiếu" , "Sắp chiếu"};
    private TabTatCa tabTatCa;
    private TabDangChieu tabDangChieu;
    private TabSapChieu tabSapChieu;
    public ListMovieApdater(@NonNull FragmentManager fm) {
        super(fm);
        tabTatCa = new TabTatCa();
        tabDangChieu = new TabDangChieu();
        tabSapChieu = new TabSapChieu();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return tabTatCa;
        }
        if(position == 1){
            return tabDangChieu;
        }
        if(position == 2){
            return tabSapChieu;
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
