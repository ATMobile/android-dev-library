package com.atmobile.library.utils;

import android.graphics.Bitmap;
import android.util.Base64;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.thefinestartist.Base;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 */
public class ImageUtils {

    /**
     * <p />
     * <b>Description:</b><br />
     * Loads the imageview asynchronously by using Picasso library.
     * <p/>
     * <p />
     * <b>Required Permissions:</b>
     * <br />android.permission.INTERNET
     * </p>
     *
     * @param url              URl string of the image to be loaded.
     * @param imageView        ImageView to be populated and returned
     * @param placeholderImage Reference to the image asset that will be used as placeholder while asynchronous load of content.
     * @param errorImage       Reference to the image asset that will be used if asynchronous load of content fails.
     * @return ImageView loaded with the image pointed with given url param.
     */
    public static ImageView loadImageView(String url, ImageView imageView, int placeholderImage, int errorImage) {
        Picasso.with(Base.getContext()).load(url).fit().placeholder(placeholderImage).error(errorImage).into(imageView);

        return imageView;
    }

    /**
     * <p />
     * <b>Description:</b><br />
     * Used for getting Base64 string equivalent of a bitmap image.
     * <p/>
     * <p />
     * <b>Required Permissions:</b> <br />
     * None.
     * </p>
     *
     * @param bitmapImage Bitmap image to be converted to Base64 string.
     * @return Base64 string representation of image.
     */
    public static String getBase64String(Bitmap bitmapImage) {

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.JPEG, 90, bao);
        byte[] ba = bao.toByteArray();
        return "data:image/jpg;base64," + Base64.encodeToString(ba, Base64.DEFAULT);
    }

    /**
     * <p />
     * <b>Description:</b><br />
     * May be used for getting Base64 string equivalents of Bitmap array.
     * <p/>
     * <p />
     * <b>Required Permissions:</b>
     * <br />-
     * </p>
     *
     * @param arrayOfBitmaps Array of bitmap images to be converted to Base64 strings
     * @return Array that contains Base64 strings of related input values.
     */
    public static ArrayList<String> getBase64StringArray(ArrayList<Bitmap> arrayOfBitmaps) {
        ArrayList<String> returnList = new ArrayList<String>();

        for (Bitmap bitmapImage : arrayOfBitmaps) {
            returnList.add(getBase64String(bitmapImage));
        }
        return returnList;
    }
}
