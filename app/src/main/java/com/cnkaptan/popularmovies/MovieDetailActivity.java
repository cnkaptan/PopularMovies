package com.cnkaptan.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnkaptan.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String MOVIE = "Movie";
    @Bind(R.id.iv_movie_poster)
    ImageView ivMoviePoster;
    @Bind(R.id.tv_release_year)
    TextView tvReleaseYear;
    @Bind(R.id.tv_duration)
    TextView tvDuration;
    @Bind(R.id.tv_rate)
    TextView tvRate;
    @Bind(R.id.bt_mark_favourite)
    Button btMarkFavourite;
    @Bind(R.id.tv_movie_name)
    TextView tvMovieName;
    @Bind(R.id.tv_overview)
    TextView tvOverview;
    private Movie movie;

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

        tvMovieName.setText(movie.getOriginal_title());
        tvRate.setText(String.format("%.2f/10.0", movie.getVote_average()));
        tvMovieName.setText(movie.getOriginal_title());
        tvReleaseYear.setText(movie.getRelease_date());
        Picasso.with(this).
                load(String.format("http://image.tmdb.org/t/p/w185/%s", movie.getPoster_path())).
                into(ivMoviePoster);
        tvOverview.setText(movie.getOverview());
    }
}
