package com.cnkaptan.popularmovies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.model.Review;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cnkaptan on 03/04/16.
 */
public class ReviewAdapter extends BaseAdapter {
    private final NoDataListener noDataListener;
    List<Review> reviews;

    public ReviewAdapter(List<Review> reviews, NoDataListener noDataListener) {
        this.noDataListener = noDataListener;
        this.reviews = reviews;
    }

    public void addReviews(List<Review> reviews) {
        if (reviews != null){
            this.reviews.addAll(reviews);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        int size = reviews.size();
        if (size == 0) {
            noDataListener.anyData(true);
        }else{
            noDataListener.anyData(false);
        }
        return size;
    }

    @Override
    public Review getItem(int position) {
        return reviews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.bind(getItem(position));
        return convertView;
    }

    public interface NoDataListener {
        void anyData(boolean nodata);
    }


    static class ViewHolder {
        @Bind(R.id.tv_author)
        TextView tvAuthor;
        @Bind(R.id.tv_review)
        TextView tvReview;
        @Bind(R.id.tv_url)
        TextView tvUrl;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void bind(Review item) {
            tvAuthor.setText(item.getAuthor());
            tvReview.setText(item.getContent());
            tvUrl.setText(item.getUrl());
        }
    }
}
