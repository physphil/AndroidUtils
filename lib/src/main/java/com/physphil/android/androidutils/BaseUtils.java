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
