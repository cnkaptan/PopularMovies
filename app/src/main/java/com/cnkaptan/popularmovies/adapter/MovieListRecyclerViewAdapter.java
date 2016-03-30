package com.cnkaptan.popularmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cnkaptan on 30/03/16.
 */
public class MovieListRecyclerViewAdapter extends RecyclerView.Adapter<MovieListRecyclerViewAdapter.MovieHolder> {
    List<Movie> movies;
    Context context;
    public MovieListRecyclerViewAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    public void addMovies(List<Movie> movies){
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        holder.bind(movies.get(position),context);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {
        ImageView ivMoviePoster;
        public MovieHolder(View v) {
            super(v);
            ivMoviePoster = (ImageView) v;
        }

        public void bind(Movie movie,Context context){
            Picasso.with(context).load(String.format("http://image.tmdb.org/t/p/w185/%s",movie.getPoster_path())).into(ivMoviePoster);
        }
    }
}
