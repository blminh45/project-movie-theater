package com.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class DangChieuAdapter extends RecyclerView.Adapter<DangChieuAdapter.ViewHolder> {
    ArrayList<PhimDangChieu> phimDangChieu;
    Context context;

    public DangChieuAdapter(ArrayList<PhimDangChieu> phimDangChieu, Context context) {
        this.phimDangChieu = phimDangChieu;
        this.context = context;
    }

    @NonNull
    @Override
    public DangChieuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_dang_chieu, parent ,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DangChieuAdapter.ViewHolder holder, int position) {
        holder.poster.setImageResource(phimDangChieu.get(position).getPoster());
        holder.name.setText(phimDangChieu.get(position).getName());
        holder.theloai.setText(phimDangChieu.get(position).getTheLoai());
        holder.tuoi.setText(Integer.toString(phimDangChieu.get(position).getTuoi()));
        holder.diem.setText(phimDangChieu.get(position).getDiem());
    }

    @Override
    public int getItemCount() {
        return phimDangChieu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView name;
        TextView theloai;
        TextView diem;
        TextView tuoi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = (ImageView)itemView.findViewById(R.id.Poster);
            name = (TextView)itemView.findViewById(R.id.Name);
            theloai = (TextView)itemView.findViewById(R.id.TheLoai);
            tuoi = (TextView)itemView.findViewById(R.id.Tuoi);
            diem = (TextView)itemView.findViewById(R.id.Diem);
        }
    }


//    ArrayList<PhimDangChieu> phimDangChieu;
//    Context context;
//
//    public DangChieuAdapter(ArrayList<PhimDangChieu> phimDangChieu, Context context) {
//        this.phimDangChieu = phimDangChieu;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public DangChieuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View itemView = layoutInflater.inflate(R.layout.item_dang_chieu, parent ,false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DangChieuAdapter.ViewHolder holder, int position) {
//        holder.poster.setImageResource(phimDangChieu.get(position).getPoster());
//        holder.name.setText(phimDangChieu.get(position).getName());
//        holder.theloai.setText(phimDangChieu.get(position).getTheLoai());
//        holder.tuoi.setText(phimDangChieu.get(position).getTuoi());
//        holder.diem.setText(phimDangChieu.get(position).getDiem());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return phimDangChieu.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView poster;
//        TextView name;
//        TextView theloai;
//        TextView diem;
//        TextView tuoi;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            poster = (ImageView)itemView.findViewById(R.id.Poster);
//            name = (TextView)itemView.findViewById(R.id.Name);
//            theloai = (TextView)itemView.findViewById(R.id.TheLoai);
//            tuoi = (TextView)itemView.findViewById(R.id.Tuoi);
//            diem = (TextView)itemView.findViewById(R.id.Diem);
//        }
//    }
}
