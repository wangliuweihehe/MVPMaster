package com.wlw.admin.mvp.api;

import com.wlw.admin.mvp.bean.BaseEntity;
import com.wlw.admin.mvp.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface ApiService {
    String BASE_URL = "http://www.hongjimeng.net/";
    String APP_V2 = "AppV2/";

    @POST(APP_V2 + "public/IndexReturn1212")
    Observable<BaseEntity<HomeBean>> getAllHomeData();
}
