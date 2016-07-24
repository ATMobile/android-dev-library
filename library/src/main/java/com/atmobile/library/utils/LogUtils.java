package com.atmobile.library.utils;

import android.util.Log;

import com.atmobile.library.Constants;
import com.thefinestartist.Base;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 */
public class LogUtils {

    /**
     * <p />
     * <b>Description:</b><br />
     * May be used for getting log tags
     * <p/>
     * <p />
     * <b>Required Permissions:</b> <br />
     * None.
     * </p>
     *
     * @param app_name Application name
     * @param callerClass Class object from where this method is called
     * @return String that is cancatenated with application name and may be used as log tag.
     */
    public static String getLogTag(String app_name, Class callerClass) {
        return app_name + "." + callerClass.getSimpleName();
    }

    /**
     * <p />
     * <b>Description:</b><br />
     * May be used for getting log tags
     * <p/>
     * <p />
     * <b>Required Permissions:</b> <br />
     * None.
     * </p>
     *
     * @param app_name Reference to the asset indicating application name
     * @param callerClass Class object from where this method is called
     * @return String that is cancatenated with application name and may be used as log tag.
     */
    public static String getLogTag(int app_name, Class callerClass) {
        return Base.getContext().getString(app_name) + "." + callerClass.getSimpleName();
    }

    /**
     * <p />
     * <b>Description:</b><br />
     * May be used for getting log tags
     * <p/>
     * <p />
     * <b>Required Permissions:</b> <br />
     * None.
     * </p>
     *
     * @param callerClass Class object from where this method is called
     * @return String that is cancatenated with application name and may be used as log tag.
     */
    public static String getLogTag(Class callerClass) {
        return Constants.APPLICATION_NAME + "." + callerClass.getSimpleName();
    }

    /**
     * <p />
     * <b>Description:</b><br />
     * May be used for getting customized log messages.
     * <p/>
     * <p />
     * <b>Required Permissions:</b>
     * <br />-
     * </p>
     *
     * @param logMessage       Custom log message. If left blank; the default value is throwable.getMessage()
     * @param throwable        Throwable that is being catched.
     * @param appendStackTrace <b>true</b> append stackTrace info to end of the log message. <b>false</b>Do not append stackTrace info. Return only the log message.
     * @return Customized log message.
     */
    public static String getLogMessage(String logMessage, Throwable throwable, boolean appendStackTrace) {
        String returnMessage = "";

        if (StringUtils.isStringNull(logMessage)) {
            logMessage = throwable.getMessage();
        }

        if (throwable != null) {
            returnMessage = logMessage + throwable.getMessage();
        } else {
            returnMessage = logMessage;
        }

        if (appendStackTrace && throwable != null) {
            returnMessage += "\n" + Log.getStackTraceString(throwable);
        }

        return returnMessage;
    }
}
