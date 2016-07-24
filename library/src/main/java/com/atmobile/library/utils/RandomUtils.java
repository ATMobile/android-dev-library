package com.atmobile.library.utils;

import android.util.Log;

import com.atmobile.library.Constants;

import java.util.Random;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 */
public class RandomUtils {

    /**
     * <p />
     * <b>Description:</b><br />
     * May be used for getting randomly generated integer.
     * <p/>
     * <p />
     * <b>Required Permissions:</b> <br />
     * None.
     * </p>
     *
     * @return an integer value that is randomly generated
     */
    public static int getRandomInteger() {
        Random random = new Random();
        return random.nextInt();
    }

    /**
     * <p />
     * <b>Description:</b><br />
     * May be used for getting MD5 hashed string value of.
     * <p/>
     * <p />
     * <b>Required Permissions:</b> <br />
     * None.
     * </p>
     *
     * @return a MD5 hashed random integer value. null if an error occurs
     */
    public static String getRandomHashedInteger() {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(String.valueOf(getRandomInteger()).getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            Log.e(LogUtils.getLogTag(Constants.APPLICATION_NAME, RandomUtils.class), LogUtils.getLogMessage(e.getMessage(), e, false));
        }
        return null;
    }
}
