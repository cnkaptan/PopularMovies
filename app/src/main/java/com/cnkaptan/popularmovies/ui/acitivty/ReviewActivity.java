package com.cnkaptan.popularmovies.ui.acitivty;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.cnkaptan.popularmovies.BaseActivity;
import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.model.Review;
import com.cnkaptan.popularmovies.model.ReviewResponse;
import com.cnkaptan.popularmovies.utils.Utils;
import com.cnkaptan.popularmovies.adapter.ReviewAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ReviewActivity extends BaseActivity {

    public static final String MOVIE_ID = "Movie Id";
    @Bind(R.id.tv_no_review)
    TextView tvNoReview;
    @Bind(R.id.lv_reviews)
    ListView lvReviews;
    private int movieId;
    private ReviewAdapter reviewAdapter;

    public static Intent newIntent(Context context, int movieId) {
        Intent intent = new Intent(context, ReviewActivity.class);
        intent.putExtra(MOVIE_ID, movieId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);

        movieId = getIntent().getIntExtra(MOVIE_ID, -1);
        initActivity();

    }

    private void initActivity() {
        reviewAdapter = new ReviewAdapter(new ArrayList<Review>(0), new ReviewAdapter.NoDataListener() {
            @Override
            public void anyData(boolean nodata) {
                if (!nodata){
                    tvNoReview.setVisibility(View.GONE);
                    lvReviews.setVisibility(View.VISIBLE);
                }else{
                    tvNoReview.setVisibility(View.VISIBLE);
                    lvReviews.setVisibility(View.GONE);
                }
            }
        });

        lvReviews.setAdapter(reviewAdapter);

        getReviews();
    }

    private void getReviews() {
        final ProgressDialog progressDialog = Utils.showLoading(this);
        movieApi.getReviews(API_KEY, movieId, new Callback<ReviewResponse>() {
            @Override
            public void success(ReviewResponse reviewResponse, Response response) {
                reviewAdapter.addReviews(reviewResponse.getReviews());
                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
            }
        });
    }
}
