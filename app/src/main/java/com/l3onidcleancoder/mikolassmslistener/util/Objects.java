package com.l3onidcleancoder.mikolassmslistener.util;

/**
 * Created by Leonid on 19.04.2014.
 */
public class Objects {

    public static boolean equal(Object obj1, Object obj2) {
        return obj1 == null ? obj2 == null : obj1.equals(obj2);
    }
}
