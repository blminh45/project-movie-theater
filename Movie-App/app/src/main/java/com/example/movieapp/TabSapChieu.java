package com.example.movieapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabSapChieu extends Fragment {
    private View sapChieuRootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sapChieuRootView = inflater.inflate(R.layout.activity_tab_sap_chieu, container , false);
        return sapChieuRootView;
    }
}
