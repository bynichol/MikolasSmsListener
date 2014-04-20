package com.l3onidcleancoder.mikolassmslistener.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Leonid on 20.04.2014.
 */
public class SmsReceiverNumberProvider {

    private static final String KEY_SMS_RECEIVER_NUMBER = "sms_receiver_number";

    public static String get(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(KEY_SMS_RECEIVER_NUMBER, "");
    }
}
