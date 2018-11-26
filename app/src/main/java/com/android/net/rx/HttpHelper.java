package com.android.net.rx;

import com.android.core.bean.BaseResponse;
import com.android.core.bean.login.LoginData;

import rx.Observable;

public interface HttpHelper {
    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 项目类别数据
     */
    Observable<BaseResponse<LoginData>> getLoginData(String username, String password);

}
