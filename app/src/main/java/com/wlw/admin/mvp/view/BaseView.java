package com.wlw.admin.mvp.view;

public interface BaseView {
    void showProgress();

    void dismissProgress();

    void onFailure(String msg);
}
