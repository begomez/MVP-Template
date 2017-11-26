package com.bernatgomez.apps.template.injection;

import com.bernatgomez.apps.template.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Specific dagger component impl
 *
 * Created by bernatgomez on 27/08/2017.
 */
@Module
public class MainModule {

    public MainPresenter providePresenter() {
        return new MainPresenter();
    }
}
