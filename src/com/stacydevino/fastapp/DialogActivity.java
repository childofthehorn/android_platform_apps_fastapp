/******************************************************************************
 * FILE: DialogActivity.java
 *
 * Copyright (c) 2011-2015 - Stacy Devino - All rights reserved.
 ******************************************************************************/
package com.stacydevino.fastapp;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import java.io.IOException;
import android.content.DialogInterface;
import android.app.Dialog;



/**
 * Blind Application to Start and Handle the Dialog Activities
 */
public class DialogActivity extends FragmentActivity {

    public static final String TAG = "DialogActivity";
    static final String ACTION = Intent.ACTION_FAST_APP;
    private static Context context;
    FragmentManager fm = getSupportFragmentManager();

    public static Context getAppContext() {
        return context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        Window window = this.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        window.setAttributes(wlp);
        new Thread(new displayThread()).start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(outState);
    }

    public class displayThread implements Runnable {
        @Override
	public void run() {
             displayMainDialog();
        }
    }

    //SHOWS THE DIALOG (MAIN)
    public void displayMainDialog()
    {
        FragmentTransaction ft = fm.beginTransaction();
        Fragment prev = fm.findFragmentByTag("AppDialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        AppDialog popUP = new AppDialog();
        // Show DialogFragment
        popUP.show(fm, "AppDialog");

    }

    public void onDestroy()
    {
        super.onDestroy();
        //finish();
    }

    public void onDismiss(DialogInterface dialog) {
        //finish();
    }

    public void onCancel(DialogInterface dialog) {
        //finish();
    }

    public void onPause() {
        super.onPause();
    }
}
