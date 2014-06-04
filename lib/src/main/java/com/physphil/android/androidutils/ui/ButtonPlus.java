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
import android.widget.Button;

import com.physphil.android.androidutils.R;

import java.util.HashMap;

/**
 * Created by pshadlyn on 6/4/2014.
 */
public class ButtonPlus extends Button {

    private Context mContext;
    private AttributeSet mAttrs;

    public ButtonPlus(Context context) {
        this(context, null);
    }

    public ButtonPlus(Context context, AttributeSet attrs) {
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

        if(TextViewPlus.mTypefaces == null){

            TextViewPlus.mTypefaces = new HashMap<String, Typeface>();
        }

        Typeface tf;
        if(TextViewPlus.mTypefaces.containsKey(typefacePath)){
            tf = TextViewPlus.mTypefaces.get(typefacePath);
        }
        else{

            tf = Typeface.createFromAsset(mContext.getAssets(), typefacePath);
            TextViewPlus.mTypefaces.put(typefacePath, tf);
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
