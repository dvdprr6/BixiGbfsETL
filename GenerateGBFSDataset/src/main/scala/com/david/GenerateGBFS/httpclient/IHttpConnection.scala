package com.david.GenerateGBFS.httpclient

trait IHttpConnection {
  def sendHttpGet(url: String) : String
}
