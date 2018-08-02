package com.mwtraking.beinmedia.hajjhealthy.ui.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;

import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.listners.ChossingImageClickListener;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Mahmoud Waked
 */
public class ChooseImageDialog extends Dialog {
    Context mContext;
    AppCompatActivity mAppCompatActivity;
    ChossingImageClickListener mChossingImageClickListener;

    public ChooseImageDialog(Context mContext, AppCompatActivity mAppCompatActivity, ChossingImageClickListener mChossingImageClickListener) {
        super(mContext);
        this.mContext = mContext;
        this.mAppCompatActivity = mAppCompatActivity;
        this.mChossingImageClickListener = mChossingImageClickListener;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.layout_choose_image);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.CENTER);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_camera)
    void onCameraClicked() {
        mChossingImageClickListener.onCameraChoose();
    }

    @OnClick(R.id.btn_gallery)
    void onGalleryClicked() {
        mChossingImageClickListener.onGalleryChoose();
    }

    @OnClick(R.id.btncancel)
    void onCancelClicked() {
        dismiss();
    }


}
