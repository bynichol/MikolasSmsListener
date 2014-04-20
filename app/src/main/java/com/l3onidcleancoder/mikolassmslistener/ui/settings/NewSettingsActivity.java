package com.l3onidcleancoder.mikolassmslistener.ui.settings;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.l3onidcleancoder.mikolassmslistener.R;
import com.l3onidcleancoder.mikolassmslistener.util.FragmentUtils;

/**
 * Created by Leonid on 20.04.2014.
 */
public class NewSettingsActivity extends FragmentActivity {

    private static class Tag {
        static final String SETTINGS_FRAGMENT = "SETTINGS_FRAGMENT";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        if (savedInstanceState == null) {
            FragmentUtils.placeFragmentOnLayout(this,
                    SettingsFragment.newInstance(), R.id.container, Tag.SETTINGS_FRAGMENT);
        }
    }
}
