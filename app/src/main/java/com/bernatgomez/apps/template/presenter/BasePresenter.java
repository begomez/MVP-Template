package com.bernatgomez.apps.template.presenter;

import com.bernatgomez.apps.template.injection.AppModule;
import com.bernatgomez.apps.template.injection.DaggerAppComponent;
import com.bernatgomez.apps.template.view.interfaces.IView;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by bernatgomez on 26/08/2017.
 */

public class BasePresenter {

    @Inject
    protected Bus bus;

    protected IView view;

    @Inject
    public BasePresenter() {
        this.init();
    }

    protected void init() {
        this.bus = DaggerAppComponent.builder().appModule(new AppModule()).build().getBus();
    }

    public void attach(IView view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

    public void start() {
        this.bus.register(this);
    }

    public void stop() {
        this.bus.unregister(this);
    }
}
