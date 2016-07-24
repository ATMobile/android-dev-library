package com.atmobile.atmobilelibrary.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionUtils {
    public ConnectionUtils() {
    }

    /**
     * Checks whether the device has Internet connection of not by looking up to Mobile and WiFi connections.
     *
     * @param context
     * @return true: device has Internet connection. false: device has NOT Internet connection.
     */
    public static boolean hasInternetConnection(Context context) {
        boolean status = false;

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                status = true;
            } else {
                netInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                    status = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
