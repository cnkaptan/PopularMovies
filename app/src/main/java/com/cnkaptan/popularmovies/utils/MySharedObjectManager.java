package com.cnkaptan.popularmovies.utils;

import com.cnkaptan.popularmovies.model.Movie;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cnkaptan on 01/02/16.
 */
public class MySharedObjectManager {

    private static final String FAVOURITE_MOVIES= "FAVOURITE_MOVIES";

    public MySharedObjectManager() {

    }

    private static void saveFavourites(List<Movie> movies){
        MySharedPrefs.saveList(FAVOURITE_MOVIES, movies);
    }

    public static void saveMovieToFavourites(Movie movie){
        List<Movie> movies =  getFavourites();
        if (movies == null){
            movies = new ArrayList<>();
        }
        Set<Movie> movieSet = new HashSet<>(movies);
        movieSet.add(movie);
        saveFavourites(new ArrayList<Movie>(movieSet));
    }

    public static List<Movie> getFavourites(){
        String favouritesGson = MySharedPrefs.loadString(FAVOURITE_MOVIES);
        Type listType = new TypeToken<List<Movie>>(){}.getType();
        List<Movie> movies = MySharedPrefs.getGson().fromJson(favouritesGson, listType);
        if (movies == null){
            movies = new ArrayList<>();
        }
        return movies;
    }

    public static void deleteMoviFromFavourites(Movie movie){
        List<Movie> movies = getFavourites();
        if (movies != null){
            movies.remove(movie);
        }
        saveFavourites(movies);
    }

}
