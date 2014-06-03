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

package com.physphil.android.androidutils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * Basic utility methods
 * Created by pshadlyn on 6/2/2014.
 */
public class BaseUtils {

    /**
     * Drafts an email to the given email address, with the given subject line and message
     * @param context
     * @param emailAddress
     * @param subject
     * @param message
     */
    public static void emailDeveloper(Context context, String emailAddress, String subject, String message){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[] {emailAddress});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, message);

        context.startActivity(i);
    }

    /**
     * Try to open app's listing in Google Play store
     * @param context context
     * @param packageName package name of app to open.  Typically found by return value of context.getPackageName() in calling application
     */
    public static void openInPlayStore(Context context, String packageName){

        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent i = new Intent(Intent.ACTION_VIEW, uri);

        try{
            context.startActivity(i);
        }
        catch(ActivityNotFoundException e){
            Toast.makeText(context, R.string.toast_google_play_error, Toast.LENGTH_LONG).show();
        }
    }

}
