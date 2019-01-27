package com.david.GBFSCron.utils.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;

import java.io.Closeable;

public interface IHttpClientFactory extends Closeable {
    public CloseableHttpClient getHttpClient();
}
