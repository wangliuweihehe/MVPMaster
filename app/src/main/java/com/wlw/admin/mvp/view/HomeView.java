package com.wlw.admin.mvp.view;

import com.wlw.admin.mvp.bean.HomeBean;

public interface HomeView extends BaseView {
    void onGetHomeData(HomeBean homeBean);
}
