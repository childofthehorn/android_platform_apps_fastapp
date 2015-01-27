/******************************************************************************
 * FILE: AppPull.java
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

/*
* Dialog to Select a Mappable App Button
*/

public class AppPullDialog extends DialogFragment {

    public static final String TAG = "AppPull";

    private static Context _context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, getTheme());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.widgetfragment, container,
                false);

        //If they do not touch it, cancel operations
        getDialog().setCanceledOnTouchOutside(true);

        //Touch back button, cancel operations
        getDialog().setCancelable(true);

////PACKAGES LIST 
                
       ArrayList<PackageInfo> res = new ArrayList<PackageInfo>();
       PackageManager pm = this.getPackageManager();
       List<PackageInfo> packages = pm.getInstalledPackages(0);
/////ALL PACKAGES
       for(int i=0; i < packages.size(); i++) {
           PackageInfo p = packages.get(i);
    	   String description = (String) p.applicationInfo.loadDescription(pm);
    	   String label= p.applicationInfo.loadLabel(pm).toString().trim();
    	   String packageName = p.packageName;
    	   String versionName = p.versionName;
    	   int versionCode = p.versionCode; 
    	   Drawable icon = p.applicationInfo.loadIcon(pm);
    	   packageName = packageName.trim();
    	   if(versionName == null){
          	versionName = "null"; 
    	   }
       	   if(versionCode == null){
    		versionCode = "null"; 
    	   }
           //Need to store icon location in Sharedprefs on click
       }
   }

}
