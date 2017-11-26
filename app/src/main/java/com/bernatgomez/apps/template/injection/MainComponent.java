package com.bernatgomez.apps.template.injection;

import com.bernatgomez.apps.template.presenter.MainPresenter;
import com.bernatgomez.apps.template.view.MainFragment;

import javax.inject.Scope;

import dagger.Component;

/**
 * Specific dagger component
 *
 * Created by bernatgomez on 27/08/2017.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {MainModule.class})
public interface MainComponent {
    public void inject(MainFragment f);

    public MainPresenter getMainPresenter();
}
