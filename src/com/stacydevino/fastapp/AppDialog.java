/******************************************************************************
 * FILE: AppDialog.java
 *
 * Copyright (c) 2011-2015 - Stacy Devino - All rights reserved.
 ******************************************************************************/
package com.stacydevino.fastapp;

import com.stacydevino.fastapp.R;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.Window;
import android.view.WindowManager;
import android.view.Gravity;
import android.text.TextUtils;
import android.util.Log;
import android.content.DialogInterface;

public class AppDialog extends DialogFragment {

    private int MAX_LENGTH_HORI = 10;
    private int MAX_LENGTH_VERT = 15;
    private String EMPTY = "               ";
    private int xDefault = 144;
    private int yDefault = 144;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, getTheme());
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        System.exit(0);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        System.exit(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.appdialog, container,
                false);

        //If they do not touch it, cancel operations
        getDialog().setCanceledOnTouchOutside(true);

        //Touch back button, cancel operations
        getDialog().setCancelable(true);

        // Make the whole thing be a window that is full transparent on top of any layer
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        wlp.dimAmount=0.0f;
        wlp.gravity = Gravity.BOTTOM;
        window.setAttributes(wlp);

        //Grab the list of APPS that are selectable!
        final String[][] appList =  //SHARED PREF_only have a MAX of 5 here due to layout (ABSTRACT TO GET MATRIX)

        //Package Names
        String packOneName = appList[0][0];
        String packTwoName = appList[0][1];
        String packThreeName = appList[0][2];
        String packFourName = appList[0][3];
        String packFiveName = appList[0][4];

        //Package Labels
        String packOneLabel = appList[1][0];
        String packTwoLabel = appList[1][1];
        String packThreeLabel = appList[1][2];
        String packFourLabel = appList[1][3];
        String packFiveLabel = appList[1][4];

        //Package Main Intents
        String packOneIntent = appList[2][0];
        String packTwoIntent = appList[2][1];
        String packThreeIntent = appList[2][2];
        String packFourIntent = appList[2][3];
        String packFiveIntent = appList[2][4];

        //Cut Labels for Apps Down to size
        String packOneText = packnOneLabel + EMPTY;
        String packTwoText = packTwoLabel + EMPTY;
        String packThreeText = packThreeLabel + EMPTY;
        String packFourText = packFourLabel + EMPTY;
        String packFiveText = packFiveLabel + EMPTY;
        packOneText = packOneText.substring( 0, MAX_LENGTH_HORI);
        packTwoText = packTwoText.substring( 0, MAX_LENGTH_HORI);
        packThreeText = packThreeText.substring( 0, MAX_LENGTH_HORI);
        packFourText = packFourText.substring( 0, MAX_LENGTH_HORI);
        packFiveText = packFiveText.substring( 0, MAX_LENGTH_HORI);

        // Watch for button clicks.
        Button packone = (Button) mainView.findViewById(R.id.packone);
        packone.setText(packOneText);

        Button packtwo = (Button) mainView.findViewById(R.id.packtwo);
        packtwo.setText(packTwoText);

        Button packthree = (Button) mainView.findViewById(R.id.packthree);
        packthree.setText(packThreeText);

        Button packfour = (Button) mainView.findViewById(R.id.packfour);
        packfour.setText(packFourText);

        Button packfive = (Button) mainView.findViewById(R.id.packfive);
        packfive.setText(packFiveText);

        PackageManager pm = this.getPackageManager();

        if(packOneName != null){
            //Use App Bitmap Here
            Drawable iconOne = pm.getApplicationIcon(packOneName);
            if(iconOne == null){
                iconOne = getDefaultActivityIcon();
            }
            //Set Button Icon (resized)
            packone.setBackgroundDrawable(BitmapOps.bitmapDrawSize(BitmapOps.drawableToBitmap(iconOne),xDefault, yDefault));
        }

        if(packTwoName != null){
            //Use App Bitmap Here
            Drawable iconTwo = pm.getApplicationIcon(packTwoName);
            if(iconTwo == null){
                iconTwo = getDefaultActivityIcon();
            }
            //Set Button Icon
            packtwo.setBackgroundDrawable(BitmapOps.bitmapDrawSize(BitmapOps.drawableToBitmap(iconTwo),xDefault, yDefault));
        }

        if(packThreeName != null){
            //Use App Bitmap Here
            Drawable iconThree = pm.getApplicationIcon(packThreeName);
            if(iconThree == null){
                iconThree = getDefaultActivityIcon();
            }
            //Set Button Icon
            packthree.setBackgroundDrawable(BitmapOps.bitmapDrawSize(BitmapOps.drawableToBitmap(iconThree),xDefault, yDefault));
        }

        if(packFourName != null){
            //Use App Bitmap Here
            Drawable iconFour = pm.getApplicationIcon(packFourName);
            if(iconFour == null){
                iconFour = getDefaultActivityIcon();
            }
            //Set Button Icon
            packfour.setBackgroundDrawable(BitmapOps.bitmapDrawSize(BitmapOps.drawableToBitmap(iconFour),xDefault, yDefault));
        }

        if(packFiveName != null){
            //Use App Bitmap Here
            Drawable iconFive = pm.getApplicationIcon(packFiveName);
            if(iconFive == null){
                iconFive = getDefaultActivityIcon();
            }
            //Set Button Icon
            packfive.setBackgroundDrawable(BitmapOps.bitmapDrawSize(BitmapOps.drawableToBitmap(iconFive),xDefault, yDefault));
        }


        packone.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if(packOneName !=null){
                   //Fire Start for package activity
                } else {
                   //Fire Intent for Activty with Dialog
                }
            }
        });

        packtwo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if(packTwoName !=null){
                   //Fire Start for package activity
                } else {
                   //Fire Intent for Activty with Dialog
                }
            }
        });

        packthree.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if(packThreeName !=null){
                   //Fire Start for package activity
                } else {
                   //Fire Intent for Activty with Dialog
                }
            }
        });

        packfour.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if(packFourName !=null){
                   //Fire Start for package activity
                } else {
                   //Fire Intent for Activty with Dialog
                }
            }
        });

        packfive.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if(packFiveName !=null){
                   //Fire Start for package activity
                } else {
                   //Fire Intent for Activty with Dialog
                }
            }
        });


        return mainView;
    }
}
