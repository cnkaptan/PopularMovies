package com.cnkaptan.popularmovies;

import android.app.Application;

import com.cnkaptan.popularmovies.utils.MySharedPrefs;

/**
 * Created by cnkaptan on 03/04/16.
 */
public class PopularMoviesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MySharedPrefs.setMySharedPrefs(getApplicationContext());
    }
}
