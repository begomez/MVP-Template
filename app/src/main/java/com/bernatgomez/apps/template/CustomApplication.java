package com.bernatgomez.apps.template;

import android.app.Application;

import com.bernatgomez.apps.template.utils.Logger;

/**
 * Created by bernatgomez on 27/08/2017.
 */

public class CustomApplication extends Application {

    private static final String TAG = CustomApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.logMsg(TAG, "onCreate()");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        Logger.logMsg(TAG, "onLowMemory()");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        Logger.logMsg(TAG, "onTrimMemory()");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        Logger.logMsg(TAG, "onTerminate()");
    }
}
