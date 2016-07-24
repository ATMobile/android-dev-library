package com.atmobile.library.utils;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 */
public class StringUtils {

    /**
     * <p />
     * <b>Description:</b><br />
     * Checks wheter input string is null (null, "null", or zero length string) and returns accordingly.
     * <p/>
     * <p />
     * <b>Required Permissions:</b> <br />
     * None.
     * </p>
     *
     * @param string String value to be checked
     * @return true, If the input string is null, else false.
     */
    public static boolean isStringNull(String string) {
        if (string == null || "null".equalsIgnoreCase(string) || string.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
