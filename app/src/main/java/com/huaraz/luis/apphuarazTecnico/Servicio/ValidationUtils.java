package com.huaraz.luis.apphuarazTecnico.Servicio;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;

/**
 * Created by XKenokiX on 04/08/2015.
 */
public class ValidationUtils {

    public static boolean isEmpty(TextInputLayout... collTil) {

        boolean check = false;

        for (TextInputLayout til : collTil) {

            String value = til.getEditText().getText().toString().trim();

            if (TextUtils.isEmpty(value)) {
                check = true;
                til.setError("Campo Requerido");
                til.setErrorEnabled(true);
            }
            else {
                til.setErrorEnabled(false);
            }

        }

        return check;

    }

    public static void cleanError(TextInputLayout... collTil) {
        for (TextInputLayout til : collTil) {
            til.setErrorEnabled(false);
        }
    }

}
