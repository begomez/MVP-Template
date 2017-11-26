package com.bernatgomez.apps.template.presenter;

import com.bernatgomez.apps.template.injection.AppModule;
import com.bernatgomez.apps.template.injection.DaggerAppComponent;
import com.example.IDataUsecase;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

/**
 * Created by bernatgomez on 27/08/2017.
 */

public class MainPresenter extends BasePresenter {

    @Inject
    protected IDataUsecase usecase;


    @Inject
    public MainPresenter() {
        super();
    }

    @Override
    protected void init() {
        super.init();

        this.usecase = DaggerAppComponent.builder().appModule(new AppModule()).build().getDataUsecase();
    }

    public void getData() {

        this.view.showLoading();

        this.usecase.getData();
    }

    @Subscribe
    public void onDataReceived(Integer data) {
        this.view.hideLoading();
    }

}
