package com.mwtraking.beinmedia.hajjhealthy.ui.activities;


import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.ParentActivity;
import com.mwtraking.beinmedia.hajjhealthy.ui.fragments.AdvicesFragment;
import com.mwtraking.beinmedia.hajjhealthy.ui.fragments.HomeFragment;
import com.mwtraking.beinmedia.hajjhealthy.ui.fragments.ProfileFragment;
import com.mwtraking.beinmedia.hajjhealthy.ui.fragments.SettingsFragment;
import com.mwtraking.beinmedia.hajjhealthy.ui.views.BottomNavigationViewHelper;

import java.util.Stack;

import butterknife.BindView;


public class MainActivity extends ParentActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;

    String TAG  = MainActivity.class.getSimpleName() ;

    HomeFragment homeFragment ;
    ProfileFragment profileFragment;
    SettingsFragment settingsFragment ;
    AdvicesFragment advicesFragment;


    private Stack<Integer> tabsStack = new Stack<>();

    int selectedTab = 0;

    private FragmentManager fragmentManager;

    private FragmentTransaction transaction;
    private Menu drawer_menu;

    public static void startActivity(AppCompatActivity mAppCompatActivity) {
        Intent mIntent = new Intent(mAppCompatActivity, MainActivity.class);
        mAppCompatActivity.startActivity(mIntent);
    }

    @Override
    protected void initializeComponents() {

        initializeBottomNav();

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
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


    @Nullable
    public void initializeBottomNav() {
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        homeFragment = HomeFragment.newInstance();
        settingsFragment = SettingsFragment.newInstance();
        profileFragment = ProfileFragment.newInstance();
        advicesFragment = AdvicesFragment.newInstance();


        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.main_layout, homeFragment);
        transaction.add(R.id.main_layout, settingsFragment);
        transaction.add(R.id.main_layout, profileFragment);
        transaction.add(R.id.main_layout, advicesFragment);
        transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        drawer_menu = bottomNavigationView.getMenu();

        showHome(true);
    }


    @Override
    public void onBackPressed() {
        Menu drawer_menu = bottomNavigationView.getMenu();
        MenuItem menuItem = drawer_menu.findItem(R.id.menu_home);
        if (!menuItem.isChecked()) {
            menuItem.setChecked(true);
            showHome(true);
        } else {
            finish();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                showHome(true);
                break;
            case R.id.menu_advices:
                showAdvices(true);
                break;
            case R.id.menu_settings:
                showSettings(true);
                break;
            case R.id.menu_profile:
                showProfile(true);
                break;
        }
        return true;
    }


    private void showAdvices(final boolean b) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            drawer_menu.findItem(R.id.menu_advices).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.colorPrimary));
            drawer_menu.findItem(R.id.menu_settings).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_profile).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_home).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
        }


        if (b) {
            if (selectedTab != 0) {
                tabsStack.push(selectedTab);
            }
        }
        transaction = fragmentManager.beginTransaction();
        transaction.hide(homeFragment);
        transaction.hide(settingsFragment);
        transaction.hide(profileFragment);
        transaction.show(advicesFragment);
        transaction.commit();
        selectedTab = R.id.menu_advices;

        drawer_menu = bottomNavigationView.getMenu();

    }


    private void showHome(final boolean b) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            drawer_menu.findItem(R.id.menu_advices).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_settings).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_profile).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_home).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.colorPrimary));
        }

        MenuItem menuItem = drawer_menu.findItem(R.id.menu_home);
        menuItem.setChecked(true);
        if (b) {
            if (selectedTab != 0) {
                tabsStack.push(selectedTab);
            }
        }
        transaction = fragmentManager.beginTransaction();
        transaction.hide(advicesFragment);
        transaction.hide(settingsFragment);
        transaction.hide(profileFragment);
        transaction.show(homeFragment);
        transaction.commit();
        selectedTab = R.id.menu_advices;
    }


    private void showSettings(final boolean b) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            drawer_menu.findItem(R.id.menu_advices).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_settings).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.colorPrimary));
            drawer_menu.findItem(R.id.menu_profile).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_home).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
        }

        if (b) {
            if (selectedTab != 0) {
                tabsStack.push(selectedTab);
            }
        }
        transaction = fragmentManager.beginTransaction();
        transaction.hide(homeFragment);
        transaction.hide(advicesFragment);
        transaction.hide(profileFragment);
        transaction.show(settingsFragment);
        transaction.commit();
        selectedTab = R.id.menu_advices;
    }


    private void showProfile(final boolean b) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            drawer_menu.findItem(R.id.menu_advices).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_settings).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
            drawer_menu.findItem(R.id.menu_profile).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.colorPrimary));
            drawer_menu.findItem(R.id.menu_home).setIconTintList(ContextCompat.getColorStateList(
                    MainActivity.this,
                    R.color.gray));
        }

        if (b) {
            if (selectedTab != 0) {
                tabsStack.push(selectedTab);
            }
        }
        transaction = fragmentManager.beginTransaction();
        transaction.hide(homeFragment);
        transaction.hide(settingsFragment);
        transaction.hide(advicesFragment);
        transaction.show(profileFragment);
        transaction.commit();
        selectedTab = R.id.menu_advices;
    }


}
