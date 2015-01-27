/******************************************************************************
 * FILE: BitmapOps.java
 *
 * Copyright (c) 2011-2015 - Stacy Devino - All rights reserved.
 ******************************************************************************/
package com.stacydevino.fastapp;

public class BitmapOps {

    public static Bitmap drawableToBitmap (Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap); 
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static BitmapDrawable bitmapDrawSize (Bitmap bitmap, int xSize, int ySize) {
        Bitmap.createScaledBitmap(bitmap, xSize, ySize, false);
        BitmapDrawable bDrawable = new BitmapDrawable(bitmap);
        return bDrawable;
    }
}
