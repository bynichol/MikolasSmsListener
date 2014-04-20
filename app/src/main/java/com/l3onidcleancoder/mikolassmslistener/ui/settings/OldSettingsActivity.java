package com.l3onidcleancoder.mikolassmslistener.ui.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.l3onidcleancoder.mikolassmslistener.R;
import com.l3onidcleancoder.mikolassmslistener.util.LogUtils;

/**
 * Created by Leonid on 20.04.2014.
 */
public class OldSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPreferences();
    }

    @SuppressWarnings("deprecation")
    private void setPreferences() {
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.debug(WebServerAddressProvider.get(this));
    }
}
