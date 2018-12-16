package com.david.GenerateGBFS.main

import com.david.GenerateGBFS.hadoop.HDFS
import com.david.GenerateGBFS.httpclient.HttpConnection
import com.david.GenerateGBFS.utils.Constants

import org.json.JSONObject

object Main extends App{
  
  /** MAKE GET REQUEST TO RETRIEVE JSON **/
  val stationStatusResponse = HttpConnection.sendHttpGet(Constants.STATION_STATUS_JSON)
  val systemAlertsResponse = HttpConnection.sendHttpGet(Constants.SYSTEM_ALERTS_JSON)
  val systemInformationResponse = HttpConnection.sendHttpGet(Constants.SYSTEM_INFORMATION_JSON)
  val stationInformationResponse = HttpConnection.sendHttpGet(Constants.STATION_INFORMATION_JSON)

  /** GET JSON OBJECTS **/
  val stationStatusData = new JSONObject(stationStatusResponse).getJSONObject("data").getJSONArray("stations").toString
  val systemAlertsData = new JSONObject(systemAlertsResponse).getJSONObject("data").getJSONArray("alerts").toString
  val systemInformationData = new JSONObject(systemInformationResponse).getJSONObject("data").toString
  val stationInformationData = new JSONObject(stationInformationResponse).getJSONObject("data").getJSONArray("stations").toString

  /** REMOVE ANY UNNESSARY HDFS PATHS **/
  HDFS.remove(Constants.HDFS_STATION_STATUS)
  HDFS.remove(Constants.HDFS_SYSTEM_ALERTS)
  HDFS.remove(Constants.HDFS_SYSTEM_INFORMATION)
  HDFS.remove(Constants.HDFS_STATION_INFORMATION)

  /** WRITE JSON TO HDFS **/
  HDFS.writeToHdfs(Constants.HDFS_STATION_STATUS_JSON, stationStatusData)
  HDFS.writeToHdfs(Constants.HDFS_SYSTEM_ALERTS_JSON, systemAlertsData)
  HDFS.writeToHdfs(Constants.HDFS_SYSTEM_INFORMATION_JSON, systemInformationData)
  HDFS.writeToHdfs(Constants.HDFS_STATION_INFORMATION_JSON, stationInformationData)

  /** READ JSON FILES FROM HDFS AND CONVERT TO DATAFRAME **/
  val stationStatusDataFrame = HDFS.readFromHdfs(Constants.HDFS_STATION_STATUS_JSON, Constants.FORMAT_JSON, Constants.STATION_STATUS_COLUMNS)
  val systemAlertsDataFrame = HDFS.readFromHdfs(Constants.HDFS_SYSTEM_ALERTS_JSON, Constants.FORMAT_JSON)
  val systemInformationDataFrame = HDFS.readFromHdfs(Constants.HDFS_SYSTEM_INFORMATION_JSON, Constants.FORMAT_JSON, Constants.SYSTEM_INFORMATION_COLUMNS)
  val stationInformationDataFrame = HDFS.readFromHdfs(Constants.HDFS_STATION_INFORMATION_JSON, Constants.FORMAT_JSON, Constants.STATION_INFORMATION_COLUMNS)

  /** WRITE BACK TO HDFS IN CSV FORMAT **/
  stationStatusDataFrame.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.HDFS_STATION_STATUS)
  systemAlertsDataFrame.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.HDFS_SYSTEM_ALERTS)
  systemInformationDataFrame.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.HDFS_SYSTEM_INFORMATION)
  stationInformationDataFrame.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.HDFS_STATION_INFORMATION)
}
