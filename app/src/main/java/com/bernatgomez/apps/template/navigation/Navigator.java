package com.bernatgomez.apps.template.navigation;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bernatgomez.apps.template.view.BaseActivity;
import com.bernatgomez.apps.template.view.BaseFragment;

/**
 * Created by bernatgomez on 26/08/2017.
 */

public abstract class Navigator {

    /**
     *
     * @param activ
     * @param container
     * @param content
     */
    public static void launchFragment(BaseActivity activ, int container, BaseFragment content) {
        FragmentManager mgr = activ.getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();


        trans.replace(container, content);

        trans.addToBackStack(content.getName());

        trans.commit();

        mgr.executePendingTransactions();
    }
}
