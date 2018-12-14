package com.david.GenerateGBFS.httpclient

import org.apache.http.impl.client.CloseableHttpClient

trait IHttpClientBasicFactory {
  def getHttpClient() : CloseableHttpClient
}
