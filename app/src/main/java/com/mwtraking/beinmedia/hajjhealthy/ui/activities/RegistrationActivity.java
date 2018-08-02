package com.mwtraking.beinmedia.hajjhealthy.ui.activities;


import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.ParentActivity;

import butterknife.OnClick;

public class RegistrationActivity extends ParentActivity {


    public static void startActivity(AppCompatActivity mAppCompatActivity) {
        Intent mIntent = new Intent(mAppCompatActivity, RegistrationActivity.class);
        mAppCompatActivity.startActivity(mIntent);
    }

    @Override
    protected void initializeComponents() {
        setToolbarTitle(getString(R.string.redistration));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_registration;
    }

    @Override
    protected boolean isEnableToolbar() {
        return true;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    protected boolean isEnableBack() {
        return false;
    }

    @Override
    protected boolean hideInputType() {
        return false;
    }

    @OnClick(R.id.btnSignUp)
    void onSignUpClick(){
      DiseasesActivity.startActivity(RegistrationActivity.this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
    }

}
