package com.l3onidcleancoder.mikolassmslistener.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Leonid on 20.04.2014.
 */
public class WebServerAddressProvider {

    static final String KEY_WEB_SERVER_ADDRESS = "web_server_address";

    public static String get(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(KEY_WEB_SERVER_ADDRESS, "");
    }

}
