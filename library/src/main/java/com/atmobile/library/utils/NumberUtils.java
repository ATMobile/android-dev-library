package com.atmobile.library.utils;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 */
public class NumberUtils {

    /**
     * <p />
     * <b>Description:</b><br />
     * Used to check a whether string object is number or not
     * <p/>
     * <p />
     * <b>Required Permissions:</b><br />
     * None
     * </p>
     *
     * @param stringObject String to be checked
     * @return true if stringObject is a number, else false.
     */
    public static boolean isNumber(String stringObject) {
        Integer integer;

        try {
            integer = Integer.valueOf(stringObject);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
