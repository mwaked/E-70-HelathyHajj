package com.mwtraking.beinmedia.hajjhealthy.utils;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.EditText;

import com.mwtraking.beinmedia.hajjhealthy.R;


/**
 * Created by mahmoud waked
 */

public class ValidationUtils {

    private static final boolean isValid(String input) {
        boolean valid = true;
        if (input.trim().isEmpty()) {
            valid = false;
        }
        return valid;
    }


    public static final boolean emptyValidation(Context  context, EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public static final boolean checkError(EditText editText, TextInputLayout textInputLayout, String error_message) {
        if (!isValid(editText.getText().toString())) {
            textInputLayout.setError(error_message);
            return false;
        } else {
            textInputLayout.setError(null);
            return true;
        }
    }

    public static final boolean checkPassSize(EditText editText, String message, int size) {
        if (editText.getText().toString().length() < size) {
            editText.setError(message);
            return false;
        } else {
            editText.setError(null);
            return true;
        }

    }

    public static final boolean emptyValidationReturnBoolean(EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) {
            return false;
        }
        return true;
    }


    public static final boolean passwordSizeValidation(Context context, EditText editText) {
        if (editText.getText().toString().length() < 6) {
            return false;
        }
        return true;
    }

    public static final boolean checkNamePref(Context context, EditText editText) {
        if (editText.getText().toString().matches("^[a-zA-Z].*")) {
            return true;
        } else {
            editText.setError(context.getString(R.string.fill_empty_field));
            return false;
        }
    }


    public static boolean validateConfirmPassword(Context context, EditText et_user_password, EditText et_confirm_password ) {
        if (!et_confirm_password.getText().toString().equals(et_user_password.getText().toString().trim())) {
            return false;
        }
        return true;
    }

    public static boolean validateEmail(Context context, EditText editText) {
      if (!isValidEmail(editText.getText().toString().trim())) {
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
