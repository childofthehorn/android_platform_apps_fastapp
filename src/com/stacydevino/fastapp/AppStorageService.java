/******************************************************************************
 * FILE: StorageService.java
 *
 * Copyright (c) 2011-2015 - Stacy Devino - All rights reserved.
 ******************************************************************************/

package com.stacydevino.fastapp;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.StrictMode;
import android.util.Log;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class AppStorageService extends Service {

    
    //ID value passed to onStartCommand
    private int startId;

    public static boolean isServiceRunning = false;

    public static final String TAG = "StorageService";

    private static Context _context;


    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(policy);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        this.startId = startId;
        // Check if this service is running
        if (isServiceRunning) {
            //What to log this to?
            Log.d(TAG,"onStartCommand() * SERVICE ALREADY RUNNING *");
        } else {
            isServiceRunning = true;
            // start the Runnables
            Log.d(TAG,"Service is being started for STORAGE");
            bootService();
        }

        return startId;
    }

    public static Context getAppContext() {
        return _context;
    }

    public static void bootService(){


    }




    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
}	
