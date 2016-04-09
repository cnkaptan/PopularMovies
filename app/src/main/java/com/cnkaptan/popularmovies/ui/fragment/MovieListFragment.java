package com.cnkaptan.popularmovies.ui.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.adapter.MovieGridAdapter;
import com.cnkaptan.popularmovies.model.Movie;
import com.cnkaptan.popularmovies.model.MovieResponse;
import com.cnkaptan.popularmovies.ui.acitivty.MainActivity;
import com.cnkaptan.popularmovies.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MovieListFragment extends Fragment implements AdapterView.OnItemClickListener {
    public static final String MOVIE_LIST = "movie_list";
    @Bind(R.id.gv_movie)
    GridView gvMovie;
    private MovieGridAdapter movieGridAdapter;
    private MainActivity activity;
    private List<Movie> favouriteMovies;
    private OnMovieClickListener movieClickListener;
    private List<Movie> listOfMovies;

    public static MovieListFragment newInstance() {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (MainActivity) activity;
        this.movieClickListener = (OnMovieClickListener) activity;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null){
            listOfMovies = savedInstanceState.getParcelableArrayList(MOVIE_LIST);
        }

        initGridView();
    }


    private void getFavouriteMovies() {
        movieGridAdapter.clearDatas();
        movieGridAdapter.addMovies(favouriteMovies);
    }

    private void initGridView() {
        movieGridAdapter = new MovieGridAdapter(new ArrayList<Movie>(0));
        gvMovie.setAdapter(movieGridAdapter);
        gvMovie.setOnItemClickListener(this);
        if (listOfMovies!= null){
            movieGridAdapter.clearDatas();
            movieGridAdapter.addMovies(listOfMovies);
        }else{
            getPopularMovies();
        }
    }

    private void getPopularMovies() {
        final ProgressDialog progressDialog = Utils.showLoading(activity);
        activity.movieApi.getPopularMovies(activity.API_KEY, 1, new Callback<MovieResponse>() {
            @Override
            public void success(MovieResponse movieResponse, Response response) {
                listOfMovies = movieResponse.getResults();
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
        final ProgressDialog progressDialog = Utils.showLoading(activity);
        activity.movieApi.getTopRated(activity.API_KEY, 1, new Callback<MovieResponse>() {
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
        movieClickListener.movieClick(movieGridAdapter.getItem(position));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public interface OnMovieClickListener{
        void movieClick(Movie movie);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(MOVIE_LIST, new ArrayList<Parcelable>(listOfMovies));
    }
}
