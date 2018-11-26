package com.android.net;

import com.android.core.bean.BaseResponse;
import com.android.core.bean.login.LoginData;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface RetrofitApi {
    /**
     * 登陆http://www.wanandroid.com/user/login&username=wangchao&password=wanchen19940829
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 登陆数据
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginData>> getLoginData(@Field("username") String username, @Field("password") String password);

}
