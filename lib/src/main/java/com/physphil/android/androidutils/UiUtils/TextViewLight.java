package com.physphil.android.androidutils.UiUtils;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Subclass of TextViewPlus, specifying the default font as Roboto Light
 * Created by pshadlyn on 6/2/2014.
 */
public class TextViewLight extends TextViewPlus {

    private static final String TYPEFACE_PATH = "roboto_light.ttf";

    public TextViewLight(Context context) {
        super(context);
        setDefaultTypeface(TYPEFACE_PATH);
    }

    public TextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDefaultTypeface(TYPEFACE_PATH);
    }

    public TextViewLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setDefaultTypeface(TYPEFACE_PATH);
    }
}
