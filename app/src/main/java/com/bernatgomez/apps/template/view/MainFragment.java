package com.bernatgomez.apps.template.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bernatgomez.apps.template.R;
import com.bernatgomez.apps.template.injection.AppComponent;
import com.bernatgomez.apps.template.injection.AppModule;
import com.bernatgomez.apps.template.injection.DaggerAppComponent;
import com.bernatgomez.apps.template.injection.DaggerMainComponent;
import com.bernatgomez.apps.template.injection.MainModule;
import com.bernatgomez.apps.template.presenter.MainPresenter;
import com.bernatgomez.apps.template.utils.Logger;
import com.bernatgomez.apps.template.view.interfaces.IMainView;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by bernatgomez on 26/08/2017.
 */

public class MainFragment extends BaseFragment implements IMainView {

    @BindView(R.id.list)
    protected LinearLayout list;

    @Inject
    protected MainPresenter presenter;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_main;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        Logger.logMsg(TAG, list.toString() );

        return v;
    }

    @Override
    protected void injectDependencies() {
        super.injectDependencies();

        AppComponent component = DaggerAppComponent.builder().appModule(new AppModule()).build();

        DaggerMainComponent.builder().appComponent(component).mainModule(new MainModule()).build().inject(this);

        Logger.logMsg(TAG, presenter.toString());
    }

    @Override
    public void onStart() {
        super.onStart();

        this.presenter.attach(this);
        this.presenter.start();

    }

    @Override
    public void onStop() {
        super.onStop();

        this.presenter.stop();
    }

    @Override
    protected void fetchData() {
        super.fetchData();

        this.presenter.getData();
    }
}
