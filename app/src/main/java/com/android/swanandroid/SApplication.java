package com.android.swanandroid;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

public class SApplication  extends Application{
    private static SApplication intance;
    private boolean mCheckNetWork = true;//默认页面进行网络检查
    public static boolean isFirstRun;
    @Override
    public void onCreate() {
        super.onCreate();
        intance = this;
    }

    public static synchronized SApplication getInstance(){
        return intance;
    }
    /**跳转actvity*/
    public static void actionIntentActivity(Activity activity, Class<? extends Activity> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
    }
    public void setCheckNetWork(boolean isCheckNetWork){
        mCheckNetWork = isCheckNetWork;
    }
    public boolean getCheckNetWork(){
        return mCheckNetWork;
    }
}
