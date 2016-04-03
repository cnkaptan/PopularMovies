package com.cnkaptan.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cnkaptan.popularmovies.api.MovieApi;
import com.cnkaptan.popularmovies.model.Movie;
import com.cnkaptan.popularmovies.utils.MySharedObjectManager;

import java.util.List;

import retrofit.RestAdapter;

/**
 * Created by cnkaptan on 29/03/16.
 */
public class BaseActivity extends AppCompatActivity {

    public MovieApi movieApi;
    public static final String API_KEY = "aec6acb741640f4094e1822dd33f80d2";
    public List<Movie> favouriteMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRestApi();
    }

    @Override
    protected void onResume() {
        super.onResume();
        favouriteMovies = MySharedObjectManager.getFavourites();
    }

    private void setRestApi() {
        RestAdapter restAdapter = new RestAdapter.Builder().
                setEndpoint(getResources().getString(R.string.base_url)).
                setLogLevel(RestAdapter.LogLevel.FULL).
                build();

        movieApi = restAdapter.create(MovieApi.class);
    }

}
