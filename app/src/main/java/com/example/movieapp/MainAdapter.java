package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    List<String> listimg;
    Context context;

    public MainAdapter(List<String> listimg , Context context) {
        this.listimg =listimg;
        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_main, parent ,false);
        return new MainAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        Picasso.get().load("http://dashboard-movie-web.herokuapp.com/images/"+ listimg.get(position)).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return listimg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.img_main);
        }

    }
}
