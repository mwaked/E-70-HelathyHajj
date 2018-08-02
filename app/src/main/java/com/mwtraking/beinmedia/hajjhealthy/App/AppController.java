package com.mwtraking.beinmedia.hajjhealthy.App;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/*
created by mahmoud Waked
 */

public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}