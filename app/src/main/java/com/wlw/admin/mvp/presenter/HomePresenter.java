package com.wlw.admin.mvp.presenter;

import com.wlw.admin.mvp.bean.HomeBean;
import com.wlw.admin.mvp.model.HomeModel;
import com.wlw.admin.mvp.net.BaseObserver;
import com.wlw.admin.mvp.view.HomeView;

import io.reactivex.disposables.Disposable;


public class HomePresenter extends BasePresenterImpl<HomeView> {
    private HomeModel model;

    public HomePresenter(HomeView view) {
        super(view);
        model = new HomeModel();
    }

    public void getData() {
        if (view != null) {
            view.showProgress();
            model.getAllData().subscribe(new BaseObserver<HomeBean>() {
                @Override
                public void onSubscribe(Disposable d) {
                    addDisposable(d);
                }

                @Override
                public void onSuccess(HomeBean homeBean) {
                    view.onGetHomeData(homeBean);
                }

                @Override
                public void onFailure(String message) {
                    view.onFailure(message);
                }

                @Override
                public void onComplete() {
                    view.dismissProgress();
                }
            });
        }

    }
}
