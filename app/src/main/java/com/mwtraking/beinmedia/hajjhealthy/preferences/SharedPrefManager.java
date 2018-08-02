package com.mwtraking.beinmedia.hajjhealthy.preferences;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.mwtraking.beinmedia.hajjhealthy.App.Constant;
import com.mwtraking.beinmedia.hajjhealthy.models.UserModel;

import java.util.Locale;

import static com.mwtraking.beinmedia.hajjhealthy.App.Constant.SharedPrefKey.SHARED_PREF_NAME;


/**
 * Created by Mahmoud Waked
 */


public class SharedPrefManager {

    Context mContext;

    SharedPreferences mSharedPreferences;

    SharedPreferences.Editor mEditor;

    final static String NOTIFICATION_STATUS = "notifications_status";


    public SharedPrefManager(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, mContext.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public int getUserMethod() {
        int value = mSharedPreferences.getInt(Constant.SharedPrefKey.USER_TYPE, 0);
        return value;
    }

    public void setUserMethod(int status) {
        mEditor.putInt(Constant.SharedPrefKey.USER_TYPE, status);
        mEditor.commit();
    }

    public Boolean getLoginStatus() {
        Boolean value = mSharedPreferences.getBoolean(Constant.SharedPrefKey.LOGIN_STATUS, false);
        return value;
    }

    public void setLoginStatus(Boolean status) {
        mEditor.putBoolean(Constant.SharedPrefKey.LOGIN_STATUS, status);
        mEditor.commit();
    }

    public Boolean getNotificationStatus() {
        final SharedPreferences sharedPreferences = mContext.getSharedPreferences(
                SHARED_PREF_NAME, 0);
        Boolean value = sharedPreferences.getBoolean(NOTIFICATION_STATUS, false);
        return value;
    }

    public void setNotificationStatus(Boolean status) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,
                0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(NOTIFICATION_STATUS, status);
        editor.commit();
    }

    public Boolean getReceiveMessage() {
        Boolean value = mSharedPreferences.getBoolean(Constant.SharedPrefKey.RECEIVE_MESSAGE, false);
        return value;
    }

    public void setReceiveMessage(Boolean status) {
        mEditor.putBoolean(Constant.SharedPrefKey.RECEIVE_MESSAGE, status);
        mEditor.commit();
    }

    public void setNotificationEnabled(Boolean status) {
        mEditor.putBoolean(Constant.SharedPrefKey.NOTIFICATION_ENABLED, status);
        mEditor.commit();
    }

    public Boolean isNotificationEnabled() {
        Boolean value = mSharedPreferences.getBoolean(Constant.SharedPrefKey.NOTIFICATION_ENABLED, false);
        return value;
    }

    public String getTradmentName() {
        String value = mSharedPreferences.getString(Constant.SharedPrefKey.TREATMENT_NAME, "Reminder to take your treatment");
        return value;
    }

    public void setTradmentName(String name) {
        mEditor.putString(Constant.SharedPrefKey.TREATMENT_NAME, name);
        mEditor.commit();
    }

    public String getLanguage() {
        String lang = " ar" ;
        if(Locale.getDefault().getDisplayLanguage().equals("english")){
            lang = " en" ;
        }
        String value = mSharedPreferences.getString(Constant.SharedPrefKey.LANGUAGE, lang);
        return value;
    }

    public void setLanguage(String name) {
        mEditor.putString(Constant.SharedPrefKey.LANGUAGE, name);
        mEditor.commit();
    }

    public String getSelectedData() {
        String value = mSharedPreferences.getString(Constant.SharedPrefKey.SELECTED_DATE, "Reminder to take your treatment");
        return value;
    }

    public void setSelectedData(String date) {
        mEditor.putString(Constant.SharedPrefKey.SELECTED_DATE, date);
        mEditor.commit();
    }

    public UserModel getUserDate() {
        Gson gson = new Gson();
        return gson.fromJson(mSharedPreferences.getString(Constant.SharedPrefKey.USER, null), UserModel.class);
    }

    public void setUserDate(UserModel userModel) {
        mEditor.putString(Constant.SharedPrefKey.USER, new Gson().toJson(userModel));
        mEditor.apply();
    }

    public boolean isNew() {
        return mSharedPreferences.getBoolean(Constant.SharedPrefKey.IS_NEW, false);
    }

    public void setIsNew(boolean userIsNew) {
        mEditor.putBoolean(Constant.SharedPrefKey.IS_NEW, userIsNew);
        mEditor.apply();
    }


    public int getLoginSteps() {
        return mSharedPreferences.getInt(Constant.SharedPrefKey.STEP, 1);
    }

    public void setLoginSteps(int step) {
        mEditor.putInt(Constant.SharedPrefKey.STEP, step);
        mEditor.apply();
    }

    public void Logout() {
        mEditor.clear();
        mEditor.apply();
    }
}
