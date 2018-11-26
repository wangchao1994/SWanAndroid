package com.android.swanandroid;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

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
    /**跳转actvity*/
    public static void skipIntentActivity(Activity activity, Class<? extends Activity> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
    }
}
