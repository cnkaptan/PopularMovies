package com.cnkaptan.popularmovies;

import android.os.Bundle;
import android.widget.GridView;

import com.cnkaptan.popularmovies.adapter.MovieGridAdapter;
import com.cnkaptan.popularmovies.model.Movie;
import com.cnkaptan.popularmovies.model.MovieResponse;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity {

    @Bind(R.id.gv_movie)
    GridView gvMovie;
    private MovieGridAdapter movieGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        movieGridAdapter = new MovieGridAdapter(new ArrayList<Movie>(0));
        gvMovie.setAdapter(movieGridAdapter);
        movieApi.getPopularMovies(API_KEY, new Callback<MovieResponse>() {
            @Override
            public void success(MovieResponse movieResponse, Response response) {
                movieGridAdapter.addMovies(movieResponse.getResults());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}
