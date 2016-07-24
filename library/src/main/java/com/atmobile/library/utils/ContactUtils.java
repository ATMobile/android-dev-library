package com.atmobile.library.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;

import com.thefinestartist.utils.content.ContextUtil;

public class ContactUtils {

    /**
     * Checks the existence of a contact by its phone number.
     *
     * @param phoneNumber
     * @return true: parameter phoneNumber exists as a contact false: parameter phoneNumber NOT exists as a contact
     */
    public static boolean isContactExistsByPhoneNumber(String phoneNumber) {
        String[] mPhoneNumberProjection = {ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.Contacts.HAS_PHONE_NUMBER};

        Cursor cur = ContextUtil.getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                mPhoneNumberProjection,
                ContactsContract.Data.MIMETYPE + "='" + ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "'", null, null);
        try {
            while (cur.moveToNext()) {
                if (cur.getInt(3) == 1 && PhoneNumberUtils.compare(cur.getString(2), phoneNumber)) {
                    return true;
                }
            }
        } finally {
            if (cur != null)
                cur.close();
        }
        return false;
    }
}
