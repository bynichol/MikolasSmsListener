package com.l3onidcleancoder.mikolassmslistener.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;


/**
 * Created by Leonid on 20.04.2014.
 */
public class FragmentUtils {

    public static void placeFragmentOnLayout(android.support.v4.app.FragmentActivity activity,
                                             android.support.v4.app.Fragment fragment,
                                             int containerId,
                                             String tag) {
        android.support.v4.app.FragmentTransaction transaction =
                activity.getSupportFragmentManager().beginTransaction();
        transaction.add(containerId, fragment, tag);
        transaction.commit();
    }

    public static void placeFragmentOnLayout(Activity activity,
                                             Fragment fragment,
                                             int containerId,
                                             String tag) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        transaction.add(containerId, fragment, tag);
        transaction.commit();
    }
}
