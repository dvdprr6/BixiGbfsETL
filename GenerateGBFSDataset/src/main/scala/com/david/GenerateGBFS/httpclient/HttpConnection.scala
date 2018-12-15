package com.david.GenerateGBFS.httpclient

import org.apache.commons.io.IOUtils
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.{CloseableHttpResponse, HttpGet}
import org.apache.http.impl.client.HttpClients


object HttpConnection extends IHttpConnection {

  override def sendHttpGet(url: String): String = {
    val httpConnection = HttpClients.createDefault()

    val httpGet = new HttpGet(url)
    httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
    val httpResponse = httpConnection.execute(httpGet)
    val jsonResponseBody = extractResponseBody(httpResponse)
    httpConnection.close()

    return jsonResponseBody
  }

  private val extractResponseBody = (httpResponse: CloseableHttpResponse) => {
    IOUtils.toString(httpResponse.getEntity.getContent, "UTF-8")
  }
}
