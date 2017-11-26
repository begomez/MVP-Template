package com.bernatgomez.apps.template.injection;

import com.bernatgomez.apps.template.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bernatgomez on 27/08/2017.
 */
@Module
public class MainModule {

    @Provides
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }
}
