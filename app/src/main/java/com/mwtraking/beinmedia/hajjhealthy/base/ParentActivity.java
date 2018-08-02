package com.mwtraking.beinmedia.hajjhealthy.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.preferences.SharedPrefManager;
import com.mwtraking.beinmedia.hajjhealthy.ui.views.Toaster;
import com.mwtraking.beinmedia.hajjhealthy.utils.CommonUtil;
import com.mwtraking.beinmedia.hajjhealthy.utils.KeyboardUtils;

import butterknife.ButterKnife;

import android.app.ProgressDialog;


public abstract class ParentActivity extends AppCompatActivity {

    protected AppCompatActivity mActivity;

    protected SharedPrefManager mSharedPrefManager;
    protected Context mContext;
    protected Toaster mToaster;
    protected Bundle mSavedInstanceState;
    Toolbar toolbar;
    TextView tv_toolbar_title;
    private int menuId;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        KeyboardUtils.hideSoftInput(this);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        mContext = this;
        mActivity = this;
        mSharedPrefManager = new SharedPrefManager(mContext);
//        CommonUtil.setConfig(mSharedPrefManager.getLanguage(), this);
        CommonUtil.setConfig("en", this);
        mToaster = new Toaster(mContext);

        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        if (hideInputType()) {
            hideInputTyping();
        }

        // set layout resources
        setContentView(getLayoutResource());
        this.mSavedInstanceState = savedInstanceState;

        ButterKnife.bind(this);
        if (isEnableToolbar()) {
            configureToolbar();
        }
        initializeComponents();

        // bind Data Again After init component becouse of DataBinding issue .
        ButterKnife.bind(this);
        if (isEnableToolbar()) {
            configureToolbar();
        }


    }


    public void setToolbarTitle(String titleId) {
        if (toolbar != null) {
            tv_toolbar_title.setText(titleId);
        }
    }

    protected abstract void initializeComponents();

    /**
     * this method is responsible for configure toolbar
     * it is called when I enable toolbar in my activity
     */
    private void configureToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv_toolbar_title = (TextView) findViewById(R.id.tv_toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // check if enable back
        if (isEnableBack()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        }
    }

    /**
     * @return the layout resource id
     */
    protected abstract int getLayoutResource();

    /**
     * it is a boolean method which tell my if toolbar
     * is enabled or not
     */
    protected abstract boolean isEnableToolbar();

    /**
     * it is a boolean method which tell if full screen mode
     * is enabled or not
     */
    protected abstract boolean isFullScreen();

    /**
     * it is a boolean method which tell if back button
     * is enabled or not
     */
    protected abstract boolean isEnableBack();

    /**
     * it is a boolean method which tell if input is
     * is appeared  or not
     */
    protected abstract boolean hideInputType();

    /**
     * this method allowed me to create option menu
     */
    @SuppressLint("RestrictedApi")
    public void createOptionsMenu(int menuId) {
        Log.e("test", "test");
        this.menuId = menuId;
        invalidateOptionsMenu();
    }

    /**
     * this method allowed me to remove option menu
     */
    @SuppressLint("RestrictedApi")
    public void removeOptionsMenu() {
        menuId = 0;
        invalidateOptionsMenu();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (menuId != 0) {
            getMenuInflater().inflate(menuId, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_left);
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_left);
    }

    public void hideInputTyping() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
//    }


    protected void showProgressDialog(String message) {
//        mProgressDialog = DialogUtil.showProgressDialog(this, message, false);
    }

    protected void hideProgressDialog() {
//        if (mProgressDialog != null) {
//            mProgressDialog.dismiss();
//        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void changeStatusBarColor(int Color) {
        Window window = mActivity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(mContext, Color));
    }
}



