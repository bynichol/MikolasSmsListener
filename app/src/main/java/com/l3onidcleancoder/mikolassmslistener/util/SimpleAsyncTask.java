package com.l3onidcleancoder.mikolassmslistener.util;

import android.os.AsyncTask;

/**
 * Created by Leonid on 22.04.2014.
 */
public abstract class SimpleAsyncTask extends AsyncTask<Void, Void, Void> {

    public static void run(final Runnable runnable) {
        SimpleAsyncTask task = new SimpleAsyncTask() {
            @Override
            protected void doWork() {
                runnable.run();
            }
        };
        task.execute();
    }

    @Override
    protected final Void doInBackground(Void... params) {
        doWork();
        return null;
    }

    protected abstract void doWork();
}
