package com.example.movielibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    List<Movies> movieslist;


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, name;
        RatingBar rating;
        Button btnDelete;


        MyViewHolder (final View view) {
            super(view);

            name = view.findViewById(R.id.movieName);
            id = view.findViewById(R.id.movieID);
            rating = view.findViewById(R.id.movieRating);
            btnDelete = view.findViewById(R.id.btn_detete_record);
        }
    }

    public MovieAdapter(List<Movies> movieslist) {
        this.movieslist = movieslist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return this. movieslist.size();
    }


    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.MyViewHolder viewHolder, final int i) {
        final Movies movie = movieslist.get(i);

        viewHolder.name.setText(movie.getMovieName());
        viewHolder.id.setText(String.valueOf(movie.getMovieID()));
        viewHolder.rating.setNumStars(5);
        viewHolder.rating.setRating(movie.getMovieRating());


        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                removeItem(i);
                Toast.makeText(v.getContext(), "movie #"+movie.getMovieID()+ " deleted", Toast.LENGTH_LONG).show();
            }
            });


        viewHolder.rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromTouch) {
                movieslist.get(i).setMovieRating((int)rating);
                movieslist.set(i,  movieslist.get(i));
                notifyDataSetChanged();
                Toast.makeText(ratingBar.getContext(), "RATING CHANGED!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void removeItem(int position) {
        movieslist.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, movieslist.size());
    }


}

