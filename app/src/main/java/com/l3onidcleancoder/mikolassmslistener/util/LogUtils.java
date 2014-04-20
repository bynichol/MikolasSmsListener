package com.l3onidcleancoder.mikolassmslistener.util;

import android.util.Log;

/**
 * Created by Leonid on 20.04.2014.
 */
public class LogUtils {

    public static String getTag() {
        return "l3onid-clean-coder";
    }

    public static void debug(String message) {
        Log.d(getTag(), message);
    }


    public static void exception(Throwable e) {
        Log.e(getTag(), e.getMessage(), e);
    }
}
