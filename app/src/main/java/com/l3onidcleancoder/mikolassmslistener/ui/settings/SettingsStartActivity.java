package com.l3onidcleancoder.mikolassmslistener.ui.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.l3onidcleancoder.mikolassmslistener.R;
import com.l3onidcleancoder.mikolassmslistener.util.ApiVersionUtils;

/**
 * Created by Leonid on 19.04.2014.
 */
public class SettingsStartActivity extends Activity {

    private static final int REQUEST_CODE_SETTINGS_ACTIVITY = 145;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        if (savedInstanceState == null) {
            startSettingsActivity();
        }
    }

    private void startSettingsActivity() {
        if (ApiVersionUtils.isCurrentVersionLowerThan(11)) {
            startActivityForResult(OldSettingsActivity.class);
        } else {
            startActivityForResult(NewSettingsActivity.class);
        }
    }

    private void startActivityForResult(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivityForResult(intent, REQUEST_CODE_SETTINGS_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
    }
}
