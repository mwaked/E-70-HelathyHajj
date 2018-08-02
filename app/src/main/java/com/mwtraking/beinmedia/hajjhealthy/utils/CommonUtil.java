package com.mwtraking.beinmedia.hajjhealthy.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.google.gson.Gson;
import com.mwtraking.beinmedia.hajjhealthy.App.AppController;
import com.mwtraking.beinmedia.hajjhealthy.App.Constant;
import com.mwtraking.beinmedia.hajjhealthy.BuildConfig;
import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.ui.views.Toaster;

import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.text.format.DateUtils.MINUTE_IN_MILLIS;


public class CommonUtil {

    public static boolean isALog = true;

    public static void onPrintLog(Object o) {
        if (isALog) {
            Log.e("Response >>>>", new Gson().toJson(o));
        }
    }

    public static void PrintLogE(String print) {
        if (BuildConfig.DEBUG) {
            Log.e(AppController.TAG, print);
        }
    }


    public static String makeURL(double sourceLat, double sourceLog, double destLat, double destLog) {
        StringBuilder urlString = new StringBuilder();
        urlString.append("http://maps.googleapis.com/maps/api/directions/json");
        urlString.append("?origin=");// from
        urlString.append(Double.toString(sourceLat));
        urlString.append(",");
        urlString.append(Double.toString(sourceLog));
        urlString.append("&destination=");// to
        urlString.append(Double.toString(destLat));
        urlString.append(",");
        urlString.append(Double.toString(destLog));
        urlString.append("&sensor=false&mode=driving&alternatives=true");
        return urlString.toString();
    }

    public static String getLanguage() {
        String language = Locale.getDefault().getDisplayLanguage();
        return language;


    }

    public static void requestFocus(View view, Window window) {
        if (view.requestFocus()) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public static void ShareApp(Context context) {
        final String appPackageName = "https://play.google.com/store/apps/details?id=" + context.getPackageName(); // getPackageName() from Context or Activity object

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.share_text) + appPackageName);
        sendIntent.setType("text/plain");
        sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(sendIntent);
    }

    public static void RateApp(AppCompatActivity context) {
        final String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public static int handleException(Context context, Throwable t) {
        if (t instanceof SocketTimeoutException) {
            makeToast(context, R.string.time_out_error);
            return R.string.time_out_error;
        } else if (t instanceof UnknownHostException) {
            makeToast(context, R.string.connection_error);
            return R.string.connection_error;
        } else if (t instanceof ConnectException) {
            makeToast(context, R.string.connection_error);
            return R.string.connection_error;
        } else if (t instanceof NoRouteToHostException) {
            makeToast(context, R.string.connection_error);
            return R.string.connection_error;
        } else if (t instanceof PortUnreachableException) {
            makeToast(context, R.string.connection_error);
            return R.string.connection_error;
        } else if (t instanceof UnknownServiceException) {
            makeToast(context, R.string.connection_error);
            return R.string.connection_error;
        } else if (t instanceof BindException) {
            makeToast(context, R.string.connection_error);
            return R.string.connection_error;
        } else {
            makeToast(context, t.getLocalizedMessage());
            return R.string.connection_error;
        }
    }

    public static void makeToast(Context context, int msgId) {
        Toaster toaster = new Toaster(context);
        toaster.makeToast(context.getString(msgId));

    }

    public static void makeToast(Context context, String msg) {
        Toaster toaster = new Toaster(context);
        toaster.makeToast(msg);

    }


    public static void setConfig(String language, Context context) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config,
                context.getResources().getDisplayMetrics());

    }


    public static String getFormattedTime(String date) {
        Date parse = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            parse = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        long updated = calendar.getTimeInMillis();
        return DateUtils.getRelativeTimeSpanString(updated, System.currentTimeMillis(), MINUTE_IN_MILLIS).toString();
    }

    public void showParElevation(boolean showHide, AppBarLayout app_bar, float elevation) {
        if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
            if (showHide) {
                app_bar.setElevation(elevation);

            } else {
                app_bar.setElevation((float) 0.0);
            }
        }
    }


    public static void makeSnake(AppCompatActivity appCompatActivity , View v , int message){
        final Snackbar snackbar = Snackbar.make(v,message, Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout)snackbar.getView();
        layout.setPadding(0, 0, 0, 0);//set padding to 0
        TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);
        final View snackView = appCompatActivity.getLayoutInflater().inflate(R.layout.custom_snack_bar, layout);
        TextView tv_snacktext = (TextView)snackView.findViewById(R.id.tv_snacktext);
        tv_snacktext.setText(message);
        snackView.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackView.setVisibility(View.GONE);
            }
        });

        //layout.addView(snackView, 0);
        snackbar.show();
    }

    public static void PrintResponseLog(Object o) {
            Log.e("Tagd", "response :" + new Gson().toJson(o));
    }

    // Playing notification sound
    public static void playSound(Context context , int Soundtype) {
        try {
            Uri alarmSound = null;
            if (Soundtype == Constant.NotificationType.NotificationSound) {
                alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                        + "://" + context.getPackageName() + "/raw/notification");
            }else if (Soundtype == Constant.NotificationType.ChatSound){
                alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                        + "://" + context.getPackageName() + "/raw/whatapp_new_message");
            }
            Ringtone r = RingtoneManager.getRingtone(context, alarmSound);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
