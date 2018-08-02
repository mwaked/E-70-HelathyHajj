package com.mwtraking.beinmedia.hajjhealthy.ui.fragments;



import android.view.View;
import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.BaseFragment;


public class ProfileFragment extends BaseFragment {


    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void initializeComponents(View view) {

    }

}