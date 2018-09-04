package com.wlw.admin.mvp.widget.loadingView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wlw.admin.mvp.R;
import com.wlw.admin.mvp.widget.loadingView.sprite.Sprite;

public class LoadingDialog extends DialogFragment {
    private TextView tvTitle;
    private SpinKitView spinKitView;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_load_view, null);
        Dialog dialog = new Dialog(context, R.style.bran_online_supervise_dialog);
        dialog.setContentView(view);
        initView(view);
        return dialog;
    }


    private void initView(View view) {
        tvTitle = view.findViewById(R.id.tv_loading_text);
        spinKitView = view.findViewById(R.id.spin_kit);
        spinKitView.setIndeterminateDrawable(SpriteFactory.create(Style.values()[6]));
    }

    public LoadingDialog setTitle(String title) {
        if (tvTitle != null)
            tvTitle.setText(title);
        return this;
    }

    public LoadingDialog setStyle(Style style) {
        Sprite drawable = SpriteFactory.create(style);
        spinKitView.setIndeterminateDrawable(drawable);
        return this;
    }
}
