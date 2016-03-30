package com.cnkaptan.popularmovies.api;

import com.cnkaptan.popularmovies.model.MovieResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by cnkaptan on 29/03/16.
 */
public interface MovieApi {

    @GET("/movie/popular")
    void getPopularMovies(@Query("api_key") String apiKey, Callback<MovieResponse> movieResponseCallback);

    @GET("/movie/top_rated")
    void getTopRated(@Query("api_key") String apiKey, Callback<MovieResponse> movieResponseCallback);

}
