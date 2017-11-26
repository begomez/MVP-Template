package com.bernatgomez.apps.template.utils;

import android.util.Log;

/**
 * Created by bernatgomez on 26/08/2017.
 */

public class Logger {

    public static void logMsg(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void logError(String tag, String msg) {
        Log.e(tag, msg);
    }
}
