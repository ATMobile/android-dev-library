package com.atmobile.library.utils;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.atmobile.library.Constants;
import com.thefinestartist.utils.content.ContextUtil;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 */
public class NetworkUtils {

    /**
     * <p />
     * <b>Description:</b><br />
     * Returns whether the there is an active network connection exists and is connected or not.
     * <p/>
     * <p />
     * <b>Required Permissions:</b>
     * <br />android.permission.ACCESS_NETWORK_STATE
     * </p>
     *
     * @return <strong>true:</strong> if there is an active connected network connection <br />
     * <strong>false: </strong>if there is no active connected network connection
     */
    public boolean isNetworkOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtil.getSystemService(Activity.CONNECTIVITY_SERVICE);
        boolean status = false;

        try {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED && netInfo.isConnected()) {
                status = true;
            }
        } catch (Exception e) {
            Log.w(LogUtils.getLogTag(Constants.APPLICATION_NAME, this.getClass()), LogUtils.getLogMessage(e.getMessage(), e, true));
            status = false;
        }
        return status;
    }
}
