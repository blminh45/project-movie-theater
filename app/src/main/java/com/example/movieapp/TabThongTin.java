package com.example.movieapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabThongTin extends Fragment {
    private View thongTinRootView;
    TextView Tomtat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        thongTinRootView = inflater.inflate(R.layout.activity_tab_thong_tin, container , false);
        Tomtat = thongTinRootView.findViewById(R.id.txtTomtat);
        String tomtat = DetailMovieActivity.phimTruyen.getTomtat();
        Tomtat.setText(tomtat);
        return thongTinRootView;
    }
}
