package com.mwtraking.beinmedia.hajjhealthy.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mahmoud
 */

public class FontUtils {

    public static void TabCustomFontSize(Context context, TabLayout tabLayout, String Font) {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    FonTChange(context, ((TextView) tabViewChild), Font);
                }
            }
        }
    }

    private static void FonTChange(Context con, TextView textView, String Fonts) {
        String fontPath = "fonts/" + Fonts;
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(con.getAssets(), fontPath);
        // Applying font
        textView.setTypeface(tf);
    }
}
