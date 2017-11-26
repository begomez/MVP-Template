package com.bernatgomez.apps.template.injection;

import com.example.IDataUsecase;
import com.example.RestDataSource;
import com.squareup.otto.Bus;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bernatgomez on 27/08/2017.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {

    //TODO: set endpoint
    public static final String ENDPOINT = "http://gateway.marvel.com/";

    public Bus getBus();

    public RestDataSource getDataSource();

    public IDataUsecase getDataUsecase();
}
