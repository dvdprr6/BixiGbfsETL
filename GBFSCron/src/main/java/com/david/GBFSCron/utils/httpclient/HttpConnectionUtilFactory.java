package com.david.GBFSCron.utils.httpclient;


public class HttpConnectionUtilFactory {
    private static IHttpConnectionUtil httpConnection;

    public static synchronized IHttpConnectionUtil getHttpConnection() {
        if(httpConnection == null) {
            httpConnection = new HttpConnectionUtil();
        }
        return httpConnection;
    }
}
