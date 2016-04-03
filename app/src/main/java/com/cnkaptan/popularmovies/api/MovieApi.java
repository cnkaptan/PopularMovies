package com.cnkaptan.popularmovies.api;

import com.cnkaptan.popularmovies.model.MovieResponse;
import com.cnkaptan.popularmovies.model.ReviewResponse;
import com.cnkaptan.popularmovies.model.TrailerResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by cnkaptan on 29/03/16.
 */
public interface MovieApi {

    @GET("/movie/popular")
    void getPopularMovies(@Query("api_key") String apiKey, @Query("page") int page,Callback<MovieResponse> movieResponseCallback);

    @GET("/movie/top_rated")
    void getTopRated(@Query("api_key") String apiKey, @Query("page") int page, Callback<MovieResponse> movieResponseCallback);

    @GET("/movie/{id}/videos")
    void getVideos(@Query("api_key") String apiKey, @Path("id") int id, Callback<TrailerResponse> movieResponseCallback);

    @GET("/movie/{id}/reviews")
    void getReviews(@Query("api_key") String apiKey, @Path("id") int id, Callback<ReviewResponse> movieResponseCallback);

}
