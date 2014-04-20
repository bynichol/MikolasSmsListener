package com.l3onidcleancoder.mikolassmslistener;

import android.app.Application;
import android.content.Context;

/**
 * Created by Leonid on 19.04.2014.
 */
public class ApplicationContextProvider extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
