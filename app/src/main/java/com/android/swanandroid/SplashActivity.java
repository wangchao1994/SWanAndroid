package com.android.swanandroid;


import com.android.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void initEventAndData() {
        mSAppContext.setCheckNetWork(true);
        if (!SApplication.isFirstRun){
            SApplication.actionIntentActivity(this,MainActivity.class);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            SApplication.isFirstRun = true;
        }
    }
    @Override
    protected void getLayoutId() {
        setContentView(R.layout.activity_splash);
    }
}
