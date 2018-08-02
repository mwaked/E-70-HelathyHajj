package com.mwtraking.beinmedia.hajjhealthy.utils;

//import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.mwtraking.beinmedia.hajjhealthy.R;


/**
 * Created by Mahmoud
 */

public final class DialogUtil {

    private DialogUtil() {
    }

//    public static ProgressDialog showProgressDialog(Context context, String message, boolean cancelable) {
//        ProgressDialog dialog = new ProgressDialog(context);
//        dialog.setMessage(message);
//        dialog.setCancelable(cancelable);
//        dialog.show();
//        return dialog;
//    }





    public static AlertDialog showAlertDialog(Context context, String message,
                                              DialogInterface.OnClickListener negativeClickListener) {
        // create the dialog builder & set message
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle(message);
        // check negative click listener
        if (negativeClickListener != null) {
            // add negative click listener
            dialogBuilder.setNegativeButton(context.getString(R.string.yes), negativeClickListener);
            dialogBuilder.setPositiveButton(context.getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
        // create and show the dialog

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
        return dialog;
    }

    public static AlertDialog showconfirm(Context context, int tittle, String message, boolean cancble,
                                          DialogInterface.OnClickListener negativeClickListener, DialogInterface.OnClickListener positiveClickListener) {
        // create the dialog builder & set message
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle(tittle);

        dialogBuilder.setMessage(message);

        // check negative click listener
        if (negativeClickListener != null) {
            // not null
            // add negative click listener
            dialogBuilder.setNegativeButton(context.getString(R.string.cancel), negativeClickListener);
        }
        if (positiveClickListener != null) {
            // not null
            // add negative click listener
            dialogBuilder.setPositiveButton(context.getString(R.string.dialog_continue), positiveClickListener);
        }
        // create and show the dialog
        dialogBuilder.setCancelable(cancble);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        return dialog;
    }
}
