package com.android.net;

import org.greenrobot.eventbus.EventBus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.core.event.NetWorkChangeEvent;
import com.android.utils.AppNetworkMgr;

public class NetWorkConnectChangeReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		boolean networkConnected = AppNetworkMgr.isNetworkConnected(context);
		Log.d("wangchao","当前网络状态：--"+networkConnected);
		EventBus.getDefault().post(new NetWorkChangeEvent(networkConnected));
	}

}
