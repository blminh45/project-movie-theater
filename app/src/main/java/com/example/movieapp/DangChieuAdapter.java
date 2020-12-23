package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class DangChieuAdapter extends RecyclerView.Adapter<DangChieuAdapter.ViewHolder> {
    ArrayList<Phim> phim;
    Context context;

    public DangChieuAdapter(ArrayList<Phim> phim, Context context) {
        this.phim = phim;
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
        holder.poster.setImageResource(phim.get(position).getPoster());
        holder.name.setText(phim.get(position).getName());
        holder.theloai.setText(phim.get(position).getTheLoai());
        holder.tuoi.setText(" "+ Integer.toString(phim.get(position).getTuoi())+"+ ");
        holder.diem.setText(" "+Float.toString(phim.get(position).getDiem())+"/10 ");

    }

    @Override
    public int getItemCount() {
        return phim.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String name = phim.get(position).getName();
            int poster = phim.get(position).getPoster();
            String theloai = phim.get(position).getTheLoai();
            float diem = phim.get(position).getDiem();
            int tuoi = phim.get(position).getTuoi();

//            Toast.makeText(context, "Phim:"+ name.toString() +"-"+Integer.toString(poster)+"-"+theloai.toString()+"-"+Float.toString(diem)+"-"+Integer.toString(tuoi),
//                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, DetailMovieActivity.class);
            intent.putExtra("MovieName", name);
            intent.putExtra("MoviePoster", Integer.toString(poster));
            intent.putExtra("MovieTheLoai", theloai);
            intent.putExtra("MovieDiem", Float.toString(diem));
            intent.putExtra("MovieTuoi", Integer.toString(tuoi));

            context.startActivity(intent);
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
