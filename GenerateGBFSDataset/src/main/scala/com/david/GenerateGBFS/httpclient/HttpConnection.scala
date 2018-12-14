package com.david.GenerateGBFS.httpclient

import org.apache.commons.io.IOUtils
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.{CloseableHttpResponse, HttpGet}


object HttpConnection extends IHttpConnection {

  override def sendHttpGet(url: String): String = {
    val httpGet = new HttpGet(url)
    httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
    val httpResponse = HttpClientBasicFactory.getHttpClient.execute(httpGet)
    val jsonResponseBody = extractResponseBody(httpResponse)

    HttpClientBasicFactory.close

    return jsonResponseBody
  }

  private val extractResponseBody = (httpResponse: CloseableHttpResponse) => {
    val responseEntity = httpResponse.getEntity
    IOUtils.toString(responseEntity.getContent, "UTF-8")
  }

}
