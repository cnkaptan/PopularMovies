package com.cnkaptan.popularmovies.ui.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cnkaptan.popularmovies.BaseActivity;
import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.adapter.TrailerAdapter;
import com.cnkaptan.popularmovies.model.Movie;
import com.cnkaptan.popularmovies.model.TrailerResponse;
import com.cnkaptan.popularmovies.model.Video;
import com.cnkaptan.popularmovies.ui.acitivty.MainActivity;
import com.cnkaptan.popularmovies.ui.acitivty.ReviewActivity;
import com.cnkaptan.popularmovies.utils.MySharedObjectManager;
import com.cnkaptan.popularmovies.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieDetailFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static final String MOVIE = "movie";
    private static final String MOVIE_SAVE_STATE = "movie_save_state";
    @Bind(R.id.tv_movie_name)
    TextView tvMovieName;
    @Bind(R.id.iv_movie_poster)
    ImageView ivMoviePoster;
    @Bind(R.id.tv_release_year)
    TextView tvReleaseYear;
    @Bind(R.id.tv_duration)
    TextView tvDuration;
    @Bind(R.id.tv_rate)
    TextView tvRate;
    @Bind(R.id.cb_favourite)
    AppCompatCheckBox cbFavourite;
    @Bind(R.id.bt_see_reviews)
    Button btSeeReviews;
    @Bind(R.id.tv_overview)
    TextView tvOverview;
    @Bind(R.id.lv_trailers)
    ListView lvTrailers;
    @Bind(R.id.ll_main)
    LinearLayout llMain;
    private Movie movie;
    private BaseActivity activity;
    private TrailerAdapter trailerAdapter;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (BaseActivity) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            movie = savedInstanceState.getParcelable(MOVIE_SAVE_STATE);
        } else if (getArguments() != null) {
            movie = getArguments().getParcelable(MOVIE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        if (movie != null){
            llMain.setVisibility(View.VISIBLE);
            initFragment(movie);

        }
        else{
            if (activity instanceof MainActivity){
                ((NoMovieContentListener)activity).noMovie();
            }
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    private void initFragment(Movie movie) {

        // bind Activity Elements
        tvMovieName.setText(movie.getOriginal_title());
        tvRate.setText(String.format("%.2f/10.0", movie.getVote_average()));
        tvMovieName.setText(movie.getOriginal_title());
        tvReleaseYear.setText(movie.getRelease_date());
        Picasso.with(activity).
                load(String.format("http://image.tmdb.org/t/p/w185/%s", movie.getPoster_path())).
                into(ivMoviePoster);
        tvOverview.setText(movie.getOverview());


        // init Trailer List
        trailerAdapter = new TrailerAdapter(new ArrayList<Video>(0));
        lvTrailers.setAdapter(trailerAdapter);
        lvTrailers.setOnItemClickListener(this);
        Utils.setListViewHeightBasedOnChildren(lvTrailers);
        getTrailers();
    }

    private void getTrailers() {
        final ProgressDialog progressDialog = Utils.showLoading(activity);
        activity.movieApi.getVideos(activity.API_KEY, movie.getId(), new Callback<TrailerResponse>() {
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
        Utils.watchYoutubeVideo(activity, trailerAdapter.getItem(position).getKey());
    }

    @OnCheckedChanged(R.id.cb_favourite)
    public void favouriteChecked(boolean checked) {
        if (checked) {
            MySharedObjectManager.saveMovieToFavourites(movie);
        } else {
            MySharedObjectManager.deleteMoviFromFavourites(movie);
        }
    }

    @OnClick(R.id.bt_see_reviews)
    public void openReviewActivity(View view) {
        startActivity(ReviewActivity.newIntent(activity, movie.getId()));
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(MOVIE_SAVE_STATE, movie);
    }

    public interface NoMovieContentListener{
        void noMovie();
    }
}
