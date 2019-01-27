package com.david.GBFSCron.utils.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.Closeable;
import java.io.IOException;

public class HttpClientBasicFactory implements IHttpClientFactory, Closeable {
    private CloseableHttpClient httpClient;

    HttpClientBasicFactory(){
        httpClient = HttpClients.createDefault();
    }

    @Override
    public void close() throws IOException {
        httpClient.close();

    }

    @Override
    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

}