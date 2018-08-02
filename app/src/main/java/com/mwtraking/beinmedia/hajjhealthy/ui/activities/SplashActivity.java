package com.mwtraking.beinmedia.hajjhealthy.ui.activities;


import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.ParentActivity;

import java.util.Locale;

import butterknife.BindView;


public class SplashActivity extends ParentActivity {

    @BindView(R.id.splash_layout)
    RelativeLayout splash_layout;

    private Animation fade;


    @Override
    protected void initializeComponents() {

        Log.e("lang", Locale.getDefault().getDisplayLanguage());

        fade = AnimationUtils.loadAnimation(this, R.anim.alpha);
        splash_layout.clearAnimation();
        splash_layout.startAnimation(fade);
        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(final Animation animation) {

            }

            @Override
            public void onAnimationEnd(final Animation animation) {

                RegistrationActivity.startActivity(SplashActivity.this);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    finishAffinity();
                }

            }

            @Override
            public void onAnimationRepeat(final Animation animation) {

            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected boolean isEnableToolbar() {
        return false;
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
}
