package com.bernatgomez.apps.template.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bernatgomez.apps.template.utils.Logger;
import com.bernatgomez.apps.template.view.interfaces.IView;

import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 26/08/2017.
 */

public class BaseFragment extends Fragment implements IView {

    protected static final String TAG = BaseFragment.class.getSimpleName();

    protected int layoutId = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.logMsg(TAG, "onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(this.layoutId, container, false);

        this.injectViews(v);

        Logger.logMsg(TAG, "onCreateView()");

        return v;
    }

    private void injectViews(View v) {
        ButterKnife.bind(this, v);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.injectDependencies();

        Logger.logMsg(TAG, "onActivityCreated()");

    }

    protected void injectDependencies() {

    }

    @Override
    public void onStart() {
        super.onStart();

        Logger.logMsg(TAG, "onStart()");

    }

    @Override
    public void onStop() {
        super.onStop();

        Logger.logMsg(TAG, "onStop()");

    }

    @Override
    public void onResume() {
        super.onResume();

        this.fetchData();

        Logger.logMsg(TAG, "onResume()");

    }

    protected void fetchData() {
    }

    @Override
    public void onPause() {
        super.onPause();

        Logger.logMsg(TAG, "onPause()");

    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Context getViewContext() {
        return super.getActivity();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
