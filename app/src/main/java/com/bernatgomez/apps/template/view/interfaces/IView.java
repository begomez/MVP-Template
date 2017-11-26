package com.bernatgomez.apps.template.view.interfaces;

import android.content.Context;

/**
 * Created by bernatgomez on 27/08/2017.
 */

public interface IView {
    public void showLoading();
    public void hideLoading();
    public Context getViewContext();
}
