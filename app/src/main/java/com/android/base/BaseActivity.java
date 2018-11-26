package com.android.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.utils.AppManager;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        getLayoutId();
        initEventAndData();
        AppManager.getAppManager().addActivity(this);
    }

    protected abstract void initEventAndData();
    protected abstract void getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        AppManager.getAppManager().removeActivity(this);
    }
}
