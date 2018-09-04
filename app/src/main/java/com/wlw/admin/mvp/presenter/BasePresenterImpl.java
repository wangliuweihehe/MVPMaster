package com.wlw.admin.mvp.presenter;

import com.wlw.admin.mvp.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter {
    private CompositeDisposable compositeDisposable;

    protected V view;

    public BasePresenterImpl(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        if (view != null)
            view = null;
        unDisposable();
    }

    @Override
    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    public void unDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
