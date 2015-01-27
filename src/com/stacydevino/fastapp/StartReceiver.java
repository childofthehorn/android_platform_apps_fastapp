/******************************************************************************
 * FILE: StartReceiver.java
 *
 * Copyright (c) 2011-2015 - Stacy Devino - All rights reserved.
 ******************************************************************************/

package com.stacydevino.fastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.util.Log;

public class StartReceiver extends BroadcastReceiver {

    public static final String TAG = "StartReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_FAST_APP)) {
            Log.d(TAG, "FastApp button press Detected");
            Intent intentForDialog = new Intent(context, WidgetActivity.class);
            intentForDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentForDialog.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intentForDialog);
        }
/*
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {

            started = true;
            Log.d(TAG, "Device Boot Detected");
            Intent intentForService = new Intent(context, AppStorageService.class);
            context.startService(intentForService);
        }
*/
    }
}
