package com.cnkaptan.popularmovies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cnkaptan on 30/03/16.
 */
public class MovieGridAdapter extends BaseAdapter {
    List<Movie> movies;

    public MovieGridAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovies(List<Movie> movies) {
        if (movies != null){
            this.movies.addAll(movies);
            notifyDataSetChanged();
        }
    }

    public void clearDatas(){
        this.movies.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Movie getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        Picasso.with(parent.getContext()).load(String.format("http://image.tmdb.org/t/p/w185/%s",
                getItem(position).getPoster_path())).into(vh.ivMovieItem);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_movie_item)
        ImageView ivMovieItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }



    }
}
