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
import android.util.AttributeSet;

/**
 * Subclass of TextViewPlus, specifying the default font as Roboto Light
 * Created by pshadlyn on 6/2/2014.
 */
public class TextViewLight extends TextViewPlus {

    private static final String TYPEFACE_PATH = "font_roboto_light.ttf";

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
