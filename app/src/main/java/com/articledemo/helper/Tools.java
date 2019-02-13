package com.articledemo.helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Helper tool class for general functions
 */
public class Tools {

    /**
     * Show the toast to user as a message
     *
     * @param mContext Context of current activity
     * @param message  Message to show
     */
    public static void showToast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show the toast to user as a message
     *
     * @param mContext Context of activity
     * @param message  String id of that message
     */
    public static void showToast(Context mContext, int message) {
        showToast(mContext, mContext.getString(message));
    }
}
