// Generated code from Butter Knife. Do not modify!
package com.cnkaptan.popularmovies.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MovieGridAdapter$ViewHolder$$ViewBinder<T extends com.cnkaptan.popularmovies.adapter.MovieGridAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492960, "field 'ivMovieItem'");
    target.ivMovieItem = finder.castView(view, 2131492960, "field 'ivMovieItem'");
  }

  @Override public void unbind(T target) {
    target.ivMovieItem = null;
  }
}
