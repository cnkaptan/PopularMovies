package com.cnkaptan.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cnkaptan.popularmovies.api.MovieApi;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by cnkaptan on 29/03/16.
 */
public class BaseActivity extends AppCompatActivity {

    public MovieApi movieApi;
    public static final String API_KEY = "aec6acb741640f4094e1822dd33f80d2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRestApi();
    }


    private void setRestApi() {
        RestAdapter restAdapter = new RestAdapter.Builder().
                setEndpoint(getResources().getString(R.string.base_url)).
                setLogLevel(RestAdapter.LogLevel.FULL).
                build();

        movieApi = restAdapter.create(MovieApi.class);
    }

}
