package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SapChieuAdapter extends RecyclerView.Adapter<SapChieuAdapter.ViewHolder> {
    ArrayList<Phim> phimsapchieu;
    Context context;

    public SapChieuAdapter(ArrayList<Phim> phim, Context context) {
        this.phimsapchieu = phim;
        this.context = context;
    }

    @NonNull
    @Override
    public SapChieuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_sap_chieu, parent ,false);
        return new SapChieuAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SapChieuAdapter.ViewHolder holder, int position) {
        holder.poster.setImageResource(phimsapchieu.get(position).getPoster());
        holder.name.setText(phimsapchieu.get(position).getName());
        holder.theloai.setText(phimsapchieu.get(position).getTheLoai());
        holder.tuoi.setText(Integer.toString(phimsapchieu.get(position).getTuoi())+"+");
        holder.diem.setText(Float.toString(phimsapchieu.get(position).getDiem())+"/10");
    }

    @Override
    public int getItemCount() {
        return phimsapchieu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView poster;
        TextView name;
        TextView theloai;
        TextView diem;
        TextView tuoi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = (ImageView)itemView.findViewById(R.id.Poster_sap_chieu);
            name = (TextView)itemView.findViewById(R.id.Name_sap_chieu);
            theloai = (TextView)itemView.findViewById(R.id.TheLoai_sap_chieu);
            tuoi = (TextView)itemView.findViewById(R.id.Tuoi_sap_chieu);
            diem = (TextView)itemView.findViewById(R.id.Diem_sap_chieu);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String name = phimsapchieu.get(position).getName();
            int poster = phimsapchieu.get(position).getPoster();
            String theloai = phimsapchieu.get(position).getTheLoai();
            float diem = phimsapchieu.get(position).getDiem();
            int tuoi = phimsapchieu.get(position).getTuoi();

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
}
