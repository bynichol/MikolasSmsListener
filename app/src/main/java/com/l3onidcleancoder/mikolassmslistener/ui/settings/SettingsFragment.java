package com.l3onidcleancoder.mikolassmslistener.ui.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.l3onidcleancoder.mikolassmslistener.R;
import com.l3onidcleancoder.mikolassmslistener.util.LogUtils;

/**
 * Created by Leonid on 20.04.2014.
 */
public class SettingsFragment extends PreferenceFragment {

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.debug(WebServerAddressProvider.get(getActivity()));
    }

}
