package com.android.net.rx;

import com.android.core.bean.BaseResponse;
import com.android.core.bean.login.LoginData;
import com.android.net.RetrofitApi;

import rx.Observable;

public class RetrofitHelper implements HttpHelper{

    private RetrofitApi mRetrofitApi;
    public RetrofitHelper(RetrofitApi retrofitApi){
        mRetrofitApi = retrofitApi;
    }
    @Override
    public Observable<BaseResponse<LoginData>> getLoginData(String username, String password) {
        return mRetrofitApi.getLoginData(username,password);
    }
}
