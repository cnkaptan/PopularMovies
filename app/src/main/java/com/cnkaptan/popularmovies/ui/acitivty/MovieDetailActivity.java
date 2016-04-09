package com.cnkaptan.popularmovies.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.cnkaptan.popularmovies.BaseActivity;
import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.model.Movie;
import com.cnkaptan.popularmovies.ui.fragment.MovieDetailFragment;

public class MovieDetailActivity extends BaseActivity {

    public static final String MOVIE = "movie";
    private FragmentManager fragmentManager;
    private Movie movie;

    public static Intent newIntent(Context context,Movie movie){
        Intent intent = new Intent(context,MovieDetailActivity.class);
        intent.putExtra(MOVIE,movie);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        fragmentManager = getSupportFragmentManager();
        movie = getIntent().getParcelableExtra(MOVIE);
        addFragment(MovieDetailFragment.newInstance(movie));
    }


    public void addFragment(Fragment fragment) {
        fragmentManager.beginTransaction().
                add(R.id.fl_fragment_frame, fragment).
                commit();
    }
}
