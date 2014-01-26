package com.yiliu.imhere;

import android.app.Application;

public class ImHereApplication extends Application {
    private static ImHereApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static ImHereApplication getInstance() {
        return sInstance;
    }
}
