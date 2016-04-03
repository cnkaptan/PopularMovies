package com.cnkaptan.popularmovies.ui.acitivty;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cnkaptan.popularmovies.BaseActivity;
import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.adapter.TrailerAdapter;
import com.cnkaptan.popularmovies.model.Movie;
import com.cnkaptan.popularmovies.model.TrailerResponse;
import com.cnkaptan.popularmovies.model.Video;
import com.cnkaptan.popularmovies.utils.MySharedObjectManager;
import com.cnkaptan.popularmovies.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MovieDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private static final String MOVIE = "Movie";
    private static final String TAG = MovieDetailActivity.class.getSimpleName();
    @Bind(R.id.iv_movie_poster)
    ImageView ivMoviePoster;
    @Bind(R.id.tv_release_year)
    TextView tvReleaseYear;
    @Bind(R.id.tv_duration)
    TextView tvDuration;
    @Bind(R.id.tv_rate)
    TextView tvRate;
    @Bind(R.id.tv_movie_name)
    TextView tvMovieName;
    @Bind(R.id.tv_overview)
    TextView tvOverview;
    @Bind(R.id.lv_trailers)
    ListView lvTrailers;
    @Bind(R.id.cb_favourite)
    AppCompatCheckBox cbFavourite;
    @Bind(R.id.bt_see_reviews)
    Button btSeeReviews;
    private Movie movie;
    private TrailerAdapter trailerAdapter;
    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(MOVIE, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);


        movie = getIntent().getParcelableExtra(MOVIE);
        favouriteMovies = MySharedObjectManager.getFavourites();
        initActivity(movie);


    }

    private void initActivity(Movie movie) {

        // bind Activity Elements
        tvMovieName.setText(movie.getOriginal_title());
        tvRate.setText(String.format("%.2f/10.0", movie.getVote_average()));
        tvMovieName.setText(movie.getOriginal_title());
        tvReleaseYear.setText(movie.getRelease_date());
        Picasso.with(this).
                load(String.format("http://image.tmdb.org/t/p/w185/%s", movie.getPoster_path())).
                into(ivMoviePoster);
        tvOverview.setText(movie.getOverview());

        if (favouriteMovies.contains(movie)){
            cbFavourite.setChecked(true);
        }else{
            cbFavourite.setChecked(false);
        }
        // init Trailer List
        trailerAdapter = new TrailerAdapter(new ArrayList<Video>(0));
        lvTrailers.setAdapter(trailerAdapter);
        lvTrailers.setOnItemClickListener(this);
        Utils.setListViewHeightBasedOnChildren(lvTrailers);
        getTrailers();
    }

    private void getTrailers() {
        final ProgressDialog progressDialog = Utils.showLoading(this);
        movieApi.getVideos(API_KEY, movie.getId(), new Callback<TrailerResponse>() {
            @Override
            public void success(TrailerResponse trailerResponse, Response response) {
                trailerAdapter.addTrailers(trailerResponse.getResults());
                Utils.setListViewHeightBasedOnChildren(lvTrailers);
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
        Utils.watchYoutubeVideo(this, trailerAdapter.getItem(position).getKey());
    }

    public void openReviewActivity(View view) {
        startActivity(ReviewActivity.newIntent(this, movie.getId()));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(MOVIE, movie);
        super.onSaveInstanceState(outState);
    }

    @OnCheckedChanged(R.id.cb_favourite)
    public void favouriteChecked(boolean checked){
        if (checked){
            MySharedObjectManager.saveMovieToFavourites(movie);
        }else{
            MySharedObjectManager.deleteMoviFromFavourites(movie);
        }
    }
}
