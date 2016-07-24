package com.atmobile.library.utils;

import android.app.Activity;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.thefinestartist.utils.content.ContextUtil;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 */
public class DeviceStateUtils {

    /**
     * <p />
     * <b>Description:</b><br />
     * Returns the current IP address of device.
     * <p/>
     * <p />
     * <b>Required Permissions:</b>
     * <br />android.permission.INTERNET
     * <br />android.permission.ACCESS_NETWORK_STATE
     * </p>
     *
     * @param
     * @return String value of devices IP address or null if any exception occured.
     */
    public String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces(); networkInterfaceEnumeration.hasMoreElements(); ) {
                NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
                for (Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses(); inetAddressEnumeration.hasMoreElements(); ) {
                    InetAddress inetAddress = inetAddressEnumeration.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception ex) {
            Log.e(LogUtils.getLogTag(this.getClass()), LogUtils.getLogMessage(ex.getMessage(), ex, true));
        }
        return null;
    }

    /**
     * <p />
     * <b>Description:</b><br />
     * Returns the unique device ID, for example, the IMEI for GSM and the MEID
     * or ESN for CDMA phones. Returns null if device ID is not available (For example in emulator).
     * <p/>
     * <p />
     * <b>Required Permissions:</b>
     * <br />android.permission.READ_PHONE_STATE
     * </p>
     *
     * @param
     * @return String value of devices unique id or null
     */
    public String getImeiAddress() {
        TelephonyManager telephonyManager = (TelephonyManager) ContextUtil.getSystemService(Activity.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }
}
