package com.example.movieapp.Profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.HoaDon;
import com.example.movieapp.R;

import java.util.ArrayList;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonAdapter.ViewHolder> {
    private ArrayList<HoaDon> mHoaDon;
    private Context context;

    public HoaDonAdapter(ArrayList<HoaDon> mHoaDon, Context context) {
        this.mHoaDon = mHoaDon;
        this.context = context;
    }

    @NonNull
    @Override
    public HoaDonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View mItemView = layoutInflater.inflate(R.layout.item_hoadon, parent, false);
        return new HoaDonAdapter.ViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull HoaDonAdapter.ViewHolder holder, int position) {
        HoaDon mCurrent = mHoaDon.get(position);
        holder.TenPhim.setText(mCurrent.getTenPhim().toString());
//        holder.ThoiLuong.setText(mCurrent.toString());
//        holder.Rap.setText(mCurrent.toString());
//        holder.Ghe.setText(mCurrent.toString());
//        holder.NgayChieu.setText(mCurrent.toString());
//        holder.GioChieu.setText(mCurrent.toString());
        holder.DiaChi.setText(mCurrent.getDiaChi().toString());
    }

    @Override
    public int getItemCount() {
        return mHoaDon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final HoaDonAdapter mAdapter;
        TextView TenPhim, ThoiLuong, Rap, Ghe, NgayChieu, GioChieu, DiaChi;

        public ViewHolder(@NonNull View itemView,HoaDonAdapter adapter) {
            super(itemView);
            TenPhim = itemView.findViewById(R.id.TenPhim);
//            ThoiLuong = itemView.findViewById(R.id.ThoiLuong);
//            Rap = itemView.findViewById(R.id.TenRap);
//            Ghe = itemView.findViewById(R.id.Ghe);
//            NgayChieu = itemView.findViewById(R.id.NgayChieu);
//            GioChieu = itemView.findViewById(R.id.GioChieu);
            DiaChi = itemView.findViewById(R.id.DiaChi);
            this.mAdapter = adapter;
        }
    }
}
