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
 * Created by pshadlyn on 6/4/2014.
 */
public class RadioButtonLight extends RadioButtonPlus {

    public RadioButtonLight(Context context) {
        super(context);
        if(!isInEditMode()) {
            setDefaultTypeface(TextViewLight.TYPEFACE_PATH);
        }
    }

    public RadioButtonLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()) {
            setDefaultTypeface(TextViewLight.TYPEFACE_PATH);
        }
    }
}
