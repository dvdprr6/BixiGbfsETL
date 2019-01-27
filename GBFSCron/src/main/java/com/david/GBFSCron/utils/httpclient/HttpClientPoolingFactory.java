package com.david.GBFSCron.utils.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;

public class HttpClientPoolingFactory implements IHttpClientFactory{
    private PoolingHttpClientConnectionManager connectionManager;
    private CloseableHttpClient httpClient;

    HttpClientPoolingFactory(){
        connectionManager = new PoolingHttpClientConnectionManager();
        createHttpClient(connectionManager);
    }

    @Override
    public void close() throws IOException {
        httpClient.close();

    }

    @Override
    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    private void createHttpClient(PoolingHttpClientConnectionManager connectionManager) {
        httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
    }

}
