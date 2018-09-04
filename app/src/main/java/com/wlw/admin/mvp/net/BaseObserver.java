package com.wlw.admin.mvp.net;

import com.wlw.admin.mvp.bean.BaseEntity;

import io.reactivex.Observer;

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {

    @Override
    public void onNext(BaseEntity<T> tBaseEntity) {
        if (tBaseEntity == null)
            return;
        int CODE_RE_LOGIN = 3;
        if (tBaseEntity.getCode() == CODE_RE_LOGIN) {
            onReLogin();
        } else {
            if (tBaseEntity.isSuccess()) {
                onSuccess(tBaseEntity.getJsondata());
                onSuccessMessage(tBaseEntity.getMsg());
            } else {
                onFailure(tBaseEntity.getMsg());
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailure( ExceptionHandle.handleException(e));
    }

    @Override
    public void onComplete() {

    }

    public void onReLogin() {

    }

    public abstract void onSuccess(T t);

    public abstract void onFailure(String message);

    public void onSuccessMessage(String message) {
    }
}
