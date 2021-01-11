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

public class TatCaAdapter extends RecyclerView.Adapter<TatCaAdapter.ViewHolder>{
    ArrayList<Phim> phim;
    Context context;

    public TatCaAdapter(ArrayList<Phim> phim, Context context) {
        this.phim = phim;
        this.context = context;
    }

    @NonNull
    @Override
    public TatCaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_tat_ca, parent ,false);
        return new TatCaAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TatCaAdapter.ViewHolder holder, int position) {
//        holder.poster.setImageResource(phim.get(position).getPoster());
        Picasso.get().load("http://dashboard-movie-web.herokuapp.com/images/"+phim.get(position).getPoster()).into(holder.poster);
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
            poster = (ImageView)itemView.findViewById(R.id.Poster_tat_ca);
            name = (TextView)itemView.findViewById(R.id.Name_tat_ca);
            theloai = (TextView)itemView.findViewById(R.id.TheLoai_tat_ca);
            tuoi = (TextView)itemView.findViewById(R.id.Tuoi_tat_ca);
            diem = (TextView)itemView.findViewById(R.id.Diem_tat_ca);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String name = phim.get(position).getName();
            String poster = phim.get(position).getPoster();
            String theloai = phim.get(position).getTheLoai();
            float diem = phim.get(position).getDiem();
            int tuoi = phim.get(position).getTuoi();
            String trailer = phim.get(position).getTrailer();

//            Toast.makeText(context, "Phim:"+ name.toString() +"-"+poster+"-"+theloai.toString()+"-"+Float.toString(diem)+"-"+Integer.toString(tuoi),
//                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, DetailMovieActivity.class);
            intent.putExtra("MovieName", name);
            intent.putExtra("MoviePoster", poster);
            intent.putExtra("MovieTheLoai", theloai);
            intent.putExtra("MovieDiem", Float.toString(diem));
            intent.putExtra("MovieTuoi", Integer.toString(tuoi));
            intent.putExtra("MovieTrailer", "Q6iK6DjV_iE");

            context.startActivity(intent);
        }
    }
}
