package com.l3onidcleancoder.mikolassmslistener.util;

/**
 * Created by ls on 17.02.14.
 */
public class ApiVersionUtils {

    public static boolean isCurrentVersionLowerThan(int apiVersion) {
        return getCurrentVersion() < apiVersion;
    }

    public static int getCurrentVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }
}
