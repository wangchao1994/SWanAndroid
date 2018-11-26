package com.android.swanandroid;

import android.app.Application;

public class SApplication  extends Application{
    private static SApplication intance;
    @Override
    public void onCreate() {
        super.onCreate();
        intance = this;
    }

    public static synchronized SApplication getInstance(){
        return intance;
    }
}
