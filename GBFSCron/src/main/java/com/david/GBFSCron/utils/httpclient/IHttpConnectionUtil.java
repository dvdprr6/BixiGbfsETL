package com.david.GBFSCron.utils.httpclient;

import java.util.List;

public interface IHttpConnectionUtil {
    public String sendHttpGet(String url);
    public String sendHttpGet(String url, List<BasicNameValuePair> body);
}
