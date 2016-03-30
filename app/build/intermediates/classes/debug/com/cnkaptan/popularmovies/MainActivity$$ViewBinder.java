// Generated code from Butter Knife. Do not modify!
package com.cnkaptan.popularmovies;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.cnkaptan.popularmovies.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492945, "field 'gvMovie'");
    target.gvMovie = finder.castView(view, 2131492945, "field 'gvMovie'");
  }

  @Override public void unbind(T target) {
    target.gvMovie = null;
  }
}
