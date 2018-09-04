package com.wlw.admin.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wlw.admin.mvp.R;
import com.wlw.admin.mvp.adapter.HomeAdapter;
import com.wlw.admin.mvp.bean.HomeBean;
import com.wlw.admin.mvp.presenter.HomePresenter;
import com.wlw.admin.mvp.utils.ToastUtils;
import com.wlw.admin.mvp.view.HomeView;
import com.wlw.admin.mvp.widget.loadingView.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseMVPFragment<HomePresenter> implements HomeView {
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private List<HomeBean.ItemListBean> listBeans;
    private LoadingDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        listBeans = new ArrayList<>();
        adapter = new HomeAdapter(getContext(), listBeans);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onGetHomeData(HomeBean homeBean) {
        listBeans.addAll(homeBean.getItemList());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        if (dialog == null)
            dialog = new LoadingDialog();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        dialog.show(ft, "aa");
    }

    @Override
    public void dismissProgress() {
        if (dialog != null)
            dialog.dismiss();
    }

    @Override
    public void onFailure(String msg) {
        ToastUtils.showToast(getContext(), msg);
    }


    @NonNull
    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void loadData() {
        if (presenter != null)
            presenter.getData();
    }
}



