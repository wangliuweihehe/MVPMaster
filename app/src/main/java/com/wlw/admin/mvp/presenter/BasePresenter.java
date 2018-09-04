package com.wlw.admin.mvp.presenter;

import io.reactivex.disposables.Disposable;

public interface BasePresenter{
    void detach();

    //将网络请求的每一个disposable添加进入CompositeDisposable，再退出时候一并注销
    void addDisposable(Disposable subscription);

    //注销所有请求
    void unDisposable();
}
