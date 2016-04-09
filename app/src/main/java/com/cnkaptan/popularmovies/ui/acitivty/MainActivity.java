package com.cnkaptan.popularmovies.ui.acitivty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.cnkaptan.popularmovies.BaseActivity;
import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.model.Movie;
import com.cnkaptan.popularmovies.ui.fragment.MovieDetailFragment;
import com.cnkaptan.popularmovies.ui.fragment.MovieListFragment;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MovieListFragment.OnMovieClickListener, MovieDetailFragment.NoMovieContentListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TWO_PANE = "TWO_PANE_SAVE_STATE";
    private static final String DETAILFRAGMENT_TAG = "Detail Movie Fragment";


    private FragmentManager fragmentManager;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fl_fragment_frame) != null) {
            // The detail container view will be present only in the large-screen layouts
            // (res/layout-sw600dp). If this view is present, then the activity should be
            // in two-pane mode.
            mTwoPane = true;
            Log.e(TAG, "" + mTwoPane);
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_fragment_frame, new MovieDetailFragment(), DETAILFRAGMENT_TAG)
                        .commit();
            }
        } else {
            mTwoPane = false;
            Log.e(TAG, "" + mTwoPane);
        }
    }


    public void replaceFragment(Fragment fragment, String tag) {
        findViewById(R.id.fl_fragment_frame).setVisibility(View.VISIBLE);
        fragmentManager.beginTransaction().
                replace(R.id.fl_fragment_frame, fragment, tag).
                addToBackStack(tag).
                commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    @Override
    public void movieClick(Movie movie) {
        if (mTwoPane) {
            replaceFragment(MovieDetailFragment.newInstance(movie), MovieDetailFragment.class.getSimpleName());
        } else {
            startActivity(MovieDetailActivity.newIntent(this, movie));
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(TWO_PANE, mTwoPane);
    }

    @Override
    public void noMovie() {
        findViewById(R.id.fl_fragment_frame).setVisibility(View.GONE);
    }
}
