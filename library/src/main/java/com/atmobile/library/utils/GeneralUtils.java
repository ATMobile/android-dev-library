package com.atmobile.library.utils;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.thefinestartist.Base;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 */
public class GeneralUtils {

    /**
     * <p />
     * <b>Description:</b><br />
     * Checks the input parameter and returns the given default value if it is null.
     * <p/>
     * <p />
     * <b>Required Permissions:</b><br />
     * None.
     * </p>
     *
     * @param checkValue
     * @param defaultValue
     * @return
     */
    public static Object getValueWhenNull(Object checkValue, Object defaultValue) {
        if (checkValue == null) {
            return defaultValue;
        } else {
            return checkValue;
        }
    }
}
