/*
 * Copyright 2014 Phil Shadlyn.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.physphil.android.androidutils.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.physphil.android.androidutils.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Extended TextView to add more features.
 *
 * To set font, copy font ttf file in project assets folder in a "fonts" folder, and reference via xml property: typeface="fonts/my_font.ttf".
 * Can also subclass by passing default typeface in constructor, which creates a TextView with the specified typeface as a default
 * Created by pshadlyn on 6/2/2014.
 */
public class TextViewPlus extends TextView {

    /**
     * Cache typefaces to avoid multiple creation on pre-ICS devices. See https://code.google.com/p/android/issues/detail?id=9904
     */
    private static Map<String, Typeface> mTypefaces;
    private Context mContext;
    private AttributeSet mAttrs;

    public TextViewPlus(Context context) {
        this(context, null);
    }

    public TextViewPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mAttrs = attrs;

        if(!isInEditMode()) {
            init();
        }
    }

    /**
     * Do all initial setup for modified textview
     */
    private void init(){

        setTypefaceSpecifiedByUser();
    }

    /**
     * Set typeface for TextView from xml property or from default value
     */
    private void setTypefaceSpecifiedByUser(){

        if(mAttrs != null) {

            // Get typeface from xml property if set by user
            TypedArray styledAttributes = mContext.obtainStyledAttributes(mAttrs, R.styleable.TextViewPlus);

            if(styledAttributes != null){

                String typefacePath = styledAttributes.getString(R.styleable.TextViewPlus_typeface);

                if(typefacePath != null){

                    setTypeface(getTypefaceByUser(typefacePath));
                }

                styledAttributes.recycle();
            }
        }
    }

    /**
     * Get typeface from HashMap (if already created) or create new one
     * @param typefacePath path of typeface to use (ex: "fonts/my_typeface.ttf")
     * @return specified typeface
     */
    private Typeface getTypefaceByUser(String typefacePath){

        if(mTypefaces == null){

            mTypefaces = new HashMap<String, Typeface>();
        }

        Typeface tf;
        if(mTypefaces.containsKey(typefacePath)){
            tf = mTypefaces.get(typefacePath);
        }
        else{

            tf = Typeface.createFromAsset(mContext.getAssets(), typefacePath);
            mTypefaces.put(typefacePath, tf);
        }

        return tf;
    }

    /**
     * Method called by subclasses to set default typeface
     * @param typefacePath path to typeface asset (ex: "fonts/my_typeface.ttf")
     */
    public void setDefaultTypeface(String typefacePath){

        // Set typeface based on default
        if(typefacePath != null){

            // Default typeface has been set by subclass, use it instead of xml attribute
            setTypeface(getTypefaceByUser(typefacePath));
        }
    }

}
