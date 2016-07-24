package com.atmobile.library.utils;

import android.util.Log;

import com.atmobile.library.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Author:  Taner Inal
 * Created: 24.07.2016
 *
 * https://github.com/square/okhttp/wiki/Recipes
 */
public class WebServiceHandler {
    private static final int METHOD_GET = 1;
    private static final int METHOD_POST = 2;

    private OkHttpClient okHttpClient;
    private Map<String, String> headerMap;

    public WebServiceHandler() {
        this.okHttpClient = new OkHttpClient();
    }

    /**
     * <p />
     * <b>Description:</b><br />
     * Instantiates a webServiceHandler objest with a given headerMap object.
     * <p/>
     * <p />
     * <b>Required Permissions:</b> <br />
     * None.
     * </p>
     *
     * @param headerMap a Map<String, String> instance which will be put to the header of request.</String,>
     */
    public WebServiceHandler(Map<String, String> headerMap) {
        this.okHttpClient = new OkHttpClient();
        this.headerMap = headerMap;
    }

    private Request.Builder getRequestBuilder() {
        Request.Builder requestBuilder = new Request.Builder();

        for (Map.Entry<String, String> headerMapEntry : this.headerMap.entrySet()) {
            requestBuilder.addHeader(headerMapEntry.getKey(), headerMapEntry.getValue());
        }

        return requestBuilder;
    }

    private String makeServiceCall(String url, int method, Map<String,String> requestParamMap) {
        try {
            Request request;

            if (method == this.METHOD_POST) {
                FormBody.Builder formBodyBuilder = new FormBody.Builder();

                for (Map.Entry<String,String> requestParam:requestParamMap.entrySet()) {
                    formBodyBuilder.add(requestParam.getKey(), requestParam.getValue());
                }

                RequestBody formBody = formBodyBuilder.build();
                request = this.getRequestBuilder().url(url).post(formBody).build();
            } else if (method == this.METHOD_GET) {
                request = this.getRequestBuilder().url(url).get().build();
            } else {
                throw new Exception("Exception in ServiceHandler.makeServiceCall method: 'method' parameter should be ServiceHandler.METHOD_GET or ServiceHandler.METHOD_POST");
            }

            return this.okHttpClient.newCall(request).execute().body().string();
        } catch (Exception e) {
            Log.e(LogUtils.getLogTag(this.getClass()), LogUtils.getLogMessage(e.getMessage(), e, true));
        }

        return null;
    }

    /**
     * Parametre olarak geçilen URL'e karşılık gelen servise POST call yapmak içindir.
     *
     * @param url Çağırım yapılacak olan servis URL'i.
     * @param requestParamMap Çağırım yapılacak olan servise gönderilecek request parametreleri.
     * @return Çağırım yapılan servisten dönen response metni
     */
    public String makePostCall(String url,  Map<String,String> requestParamMap) {
        return this.makeServiceCall(url, this.METHOD_POST, requestParamMap);
    }

    /**
     * Parametre olarak geçilen URL'e karşılık gelen servise GET call yapmak içindir.
     *
     * @param url Çağırım yapılacak olan servis URL'i.
     * @return Çağırım yapılan servisten dönen response metni
     */
    public String makeGetCall(String url) {
        return this.makeServiceCall(url, this.METHOD_GET, null);
    }
}
