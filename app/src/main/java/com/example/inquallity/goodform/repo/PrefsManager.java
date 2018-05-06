package com.example.inquallity.goodform.repo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Olga Aleksandrova on 22-Apr-18.
 */

public class PrefsManager {

    private static final String KEY_SHOULD_SHOW_NAV_TIPS = "DO_NOT_SHOW_AGAIN";

    private SharedPreferences mPreferences;

    public PrefsManager(Context ctx) {
        mPreferences = ctx.getSharedPreferences("SwipeDialog", Context.MODE_PRIVATE);
    }

    public void editPreferences(boolean shouldShowAgain) {
        mPreferences.edit().putBoolean(KEY_SHOULD_SHOW_NAV_TIPS, shouldShowAgain).apply();
    }

    public boolean shouldShowNavTips() {
        return mPreferences.getBoolean(KEY_SHOULD_SHOW_NAV_TIPS, true);
    }
}
