package com.mwtraking.beinmedia.hajjhealthy.ui.fragments;


import android.view.View;
import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.BaseFragment;


public class SettingsFragment extends BaseFragment {


    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_settings;
    }

    @Override
    protected void initializeComponents(View view) {

    }

}