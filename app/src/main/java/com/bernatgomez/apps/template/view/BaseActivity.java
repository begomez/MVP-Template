package com.bernatgomez.apps.template.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bernatgomez.apps.template.R;
import com.bernatgomez.apps.template.utils.Logger;

/**
 * Created by bernatgomez on 26/08/2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected static final String TAG = BaseActivity.class.getSimpleName();

    public static final int CONTAINER_ID = R.id.main_content;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            this.launchContentFragment();
        }

        Logger.logMsg(TAG, "onCreate()");

    }

    /**
     *
     */
    protected void launchContentFragment() {}
}
