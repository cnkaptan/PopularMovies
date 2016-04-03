package com.cnkaptan.popularmovies.ui.acitivty;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cnkaptan.popularmovies.BaseActivity;
import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.adapter.MovieGridAdapter;
import com.cnkaptan.popularmovies.model.Movie;
import com.cnkaptan.popularmovies.model.MovieResponse;
import com.cnkaptan.popularmovies.utils.Utils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.gv_movie)
    GridView gvMovie;
    private MovieGridAdapter movieGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        initGridView();


    }

    @Override
    protected void onResume() {
        super.onResume();
        movieGridAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_popular:
                getPopularMovies();
                break;
            case R.id.action_top_rated:
                getTopRatedMovies();
                break;
            case R.id.action_favourites:
                getFavouriteMovies();
            break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void getFavouriteMovies() {
        movieGridAdapter.clearDatas();
        movieGridAdapter.addMovies(favouriteMovies);
    }

    private void initGridView() {
        movieGridAdapter = new MovieGridAdapter(new ArrayList<Movie>(0));
        gvMovie.setAdapter(movieGridAdapter);
        gvMovie.setOnItemClickListener(this);
        getPopularMovies();
    }

    private void getPopularMovies() {
        final ProgressDialog progressDialog = Utils.showLoading(this);
        movieApi.getPopularMovies(API_KEY, 1, new Callback<MovieResponse>() {
            @Override
            public void success(MovieResponse movieResponse, Response response) {
                movieGridAdapter.clearDatas();
                movieGridAdapter.addMovies(movieResponse.getResults());
                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
            }
        });
    }

    private void getTopRatedMovies() {
        final ProgressDialog progressDialog = Utils.showLoading(this);
        movieApi.getTopRated(API_KEY, 1, new Callback<MovieResponse>() {
            @Override
            public void success(MovieResponse movieResponse, Response response) {
                movieGridAdapter.clearDatas();
                movieGridAdapter.addMovies(movieResponse.getResults());
                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(MovieDetailActivity.newIntent(this, movieGridAdapter.getItem(position)));
    }



}
