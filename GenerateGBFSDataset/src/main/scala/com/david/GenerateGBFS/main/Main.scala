package com.david.GenerateGBFS.main

import com.david.GenerateGBFS.httpclient.HttpConnection
import com.david.GenerateGBFS.utils.Constants

object Main extends App{

  val stationInformationResponse = HttpConnection.sendHttpGet(Constants.STATION_INFORMATION_JSON)

}
