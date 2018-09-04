package com.wlw.admin.mvp.adapter;

import android.content.Context;

import com.wlw.admin.mvp.R;
import com.wlw.admin.mvp.bean.HomeBean;
import com.wlw.admin.mvp.recycler.BaseRecyclerAdapter;
import com.wlw.admin.mvp.recycler.BaseRecyclerHolder;

import java.util.List;

public class HomeAdapter extends BaseRecyclerAdapter<HomeBean.ItemListBean> {


    public HomeAdapter(Context context, List<HomeBean.ItemListBean> list) {
        super(context, list, R.layout.item_home);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, HomeBean.ItemListBean item, int position) {
        holder.setText(R.id.tv_item_name,item.getItemName());
    }
}
