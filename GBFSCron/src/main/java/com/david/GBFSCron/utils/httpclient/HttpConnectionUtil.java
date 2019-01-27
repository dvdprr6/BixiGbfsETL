package com.david.GBFSCron.utils.httpclient;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.Closeable;
import java.io.IOException;

public class HttpConnectionUtil implements IHttpConnectionUtil, Closeable {
    private IHttpClientFactory httpClientFactory;

    HttpConnectionUtil() {
        this.httpClientFactory = new HttpClientBasicFactory();
    }

    @Override
    public String sendHttpGet(String url) {
        CloseableHttpResponse execute = null;
        String jsonResponseBody = new String();

        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            execute = httpClientFactory.getHttpClient().execute(httpGet);
            jsonResponseBody = extractResponseBody(execute);
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return jsonResponseBody;
    }

    @Override
    public void close() throws IOException {
        httpClientFactory.close();
    }

    private String extractResponseBody(CloseableHttpResponse httpResponse) {
        String responseString = new String();
        try {
            HttpEntity responseEntity = httpResponse.getEntity();
            if(responseEntity != null) {
                responseString = IOUtils.toString(responseEntity.getContent(), "UTF-8");
            }
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return responseString;
    }
}
