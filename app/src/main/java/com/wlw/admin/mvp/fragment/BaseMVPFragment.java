package com.wlw.admin.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wlw.admin.mvp.presenter.BasePresenter;

public abstract class BaseMVPFragment<P extends BasePresenter> extends BaseFragment {
    public P presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
    }

    protected abstract @NonNull
    P getPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.detach();
    }
}
