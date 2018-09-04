package com.wlw.admin.mvp.model;

import com.wlw.admin.mvp.bean.BaseEntity;
import com.wlw.admin.mvp.bean.HomeBean;
import com.wlw.admin.mvp.net.RetrofitManager;

import io.reactivex.Observable;

public class HomeModel extends BaseModel {
    public Observable<BaseEntity<HomeBean>> getAllData(){
       return RetrofitManager.getInstance().createService().getAllHomeData().compose(setThread());
    }
}
