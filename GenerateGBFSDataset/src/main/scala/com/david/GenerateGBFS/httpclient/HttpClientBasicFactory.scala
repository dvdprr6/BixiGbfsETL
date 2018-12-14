package com.david.GenerateGBFS.httpclient

import org.apache.http.impl.client.{CloseableHttpClient, HttpClients}


object HttpClientBasicFactory extends IHttpClientBasicFactory with AutoCloseable{
  private lazy val httpClient: CloseableHttpClient = HttpClients.createDefault()
  override lazy val getHttpClient: CloseableHttpClient = httpClient
  override lazy val close: Unit = httpClient.close()
}
