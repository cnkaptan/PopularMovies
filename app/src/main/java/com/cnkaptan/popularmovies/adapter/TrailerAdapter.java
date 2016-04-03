package com.cnkaptan.popularmovies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnkaptan.popularmovies.R;
import com.cnkaptan.popularmovies.model.Video;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cnkaptan on 03/04/16.
 */
public class TrailerAdapter extends BaseAdapter {
    List<Video> trailers;

    public TrailerAdapter(List<Video> trailers) {
        this.trailers = trailers;
    }

    public void addTrailers(List<Video> trailers) {
        this.trailers.addAll(trailers);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return trailers.size();
    }

    @Override
    public Video getItem(int position) {
        return trailers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trailer_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.bind(position);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_play)
        ImageView ivPlay;
        @Bind(R.id.tv_trailer_name)
        TextView tvTrailerName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void bind(int position){
            tvTrailerName.setText(String.format("Trailer %d",position+1));
        }
    }
}
