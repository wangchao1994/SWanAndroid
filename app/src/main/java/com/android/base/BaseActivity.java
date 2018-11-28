package com.android.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.android.core.event.NetWorkChangeEvent;
import com.android.swanandroid.R;
import com.android.swanandroid.SApplication;
import com.android.utils.AppManager;
import com.android.utils.AppNetworkMgr;
import com.android.utils.AppToastMgr;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseActivity extends AppCompatActivity{
    protected SApplication mSAppContext;
    private View mTipView;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLayoutParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSAppContext = SApplication.getInstance();
        getLayoutId();
        initTipView();
        initEventAndData();
        EventBus.getDefault().register(this);
        AppManager.getAppManager().addActivity(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetWorkChangeEvent(NetWorkChangeEvent netWorkChangeEvent){
        Log.d("wangchao","onNetWorkChangeEvent"+netWorkChangeEvent.isConnected);
        hasChangeWorkStatus(netWorkChangeEvent.isConnected);
    }

    /**
     * 实时网络状态
     * @param isConnected
     */
    private void hasChangeWorkStatus(boolean isConnected) {
        if (mSAppContext.getCheckNetWork())
            if (isConnected) {
                if (mTipView != null && mTipView.getParent() != null){
                    mWindowManager.removeView(mTipView);
                }
            }else{
                if (mTipView != null && mTipView.getParent() != null){
                    mWindowManager.addView(mTipView, mLayoutParams);
                }
            }
    }
    @Override
    protected void onResume() {
        super.onResume();
        hasChangeWorkStatus(AppNetworkMgr.isNetworkConnected(mSAppContext));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        AppManager.getAppManager().removeActivity(this);
    }

    @Override
    public void finish() {
        super.finish();
        if (mTipView != null && mTipView.getParent() != null){
            mWindowManager.removeView(mTipView);
        }
    }

    private void initTipView() {
        LayoutInflater inLayoutInflater = getLayoutInflater();
        mTipView = inLayoutInflater.inflate(R.layout.layout_network_tipview, null);
        mWindowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        mLayoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        mLayoutParams.gravity = Gravity.TOP;
        mLayoutParams.x = 0;
        mLayoutParams.y = 0;

    }
    protected abstract void initEventAndData();
    protected abstract void getLayoutId();
}
