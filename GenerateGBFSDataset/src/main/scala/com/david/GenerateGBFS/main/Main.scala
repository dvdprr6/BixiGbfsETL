package com.david.GenerateGBFS.main

import com.david.GenerateGBFS.hadoop.HDFS
import com.david.GenerateGBFS.httpclient.HttpConnection
import com.david.GenerateGBFS.utils.{Constants, JSONParser}
import com.david.GenerateGBFS.json._
import com.david.GenerateGBFS.model._
import org.json.JSONObject


object Main extends App{
  var stationStatusList: List[MODEL] = List()
  var systemAlertsList: List[MODEL] = List()
  var systemInformationList: List[MODEL] = List()
  var stationInformationList: List[MODEL] = List()

  /** MAKE GET REQUEST TO RETRIEVE JSON **/
  val stationStatusResponse = HttpConnection.sendHttpGet(Constants.STATION_STATUS_JSON)
  val systemAlertsResponse = HttpConnection.sendHttpGet(Constants.SYSTEM_ALERTS_JSON)
  val systemInformationResponse = HttpConnection.sendHttpGet(Constants.SYSTEM_INFORMATION_JSON)
  val stationInformationResponse = HttpConnection.sendHttpGet(Constants.STATION_INFORMATION_JSON)

  /** GET JSON OBJECTS **/
  val stationStatusData = new JSONObject(stationStatusResponse).getJSONObject("data").getJSONArray("stations")
  val systemAlertsData = new JSONObject(systemAlertsResponse).getJSONObject("data").getJSONArray("alerts")
  val systemInformationData = new JSONObject(systemInformationResponse).getJSONObject("data")
  val stationInformationData = new JSONObject(stationInformationResponse).getJSONObject("data").getJSONArray("stations")

  /* CONVERT JSON OBJECTS TO JSON MODELS **/
  for(i <- 0 until stationStatusData.length()){
    val json = stationStatusData.getJSONObject(i).toString()
    val stationStatusJSON = JSONParser.parseJSON[StationStatusJSON](json, classOf[StationStatus])
    stationStatusList = stationStatusList :+ stationStatusJSON.toModel
  }

  for(i <- 0 until systemAlertsData.length()){
    val json = systemAlertsData.getJSONObject(i).toString()
    val systemAlertsJSON = JSONParser.parseJSON[SystemAlertsJSON](json, classOf[SystemAlerts])
    systemAlertsList = systemAlertsList :+ systemAlertsJSON.toModel
  }

  val systemInformationModel = JSONParser.parseJSON[SystemInformationJSON](systemInformationData.toString(), classOf[SystemInformation]).toModel

  for(i <- 0 until stationInformationData.length()){
    val json = stationInformationData.getJSONObject(i).toString()
    val stationInformationJSON = JSONParser.parseJSON[StationInformationJSON](json, classOf[StationInformation])
    stationInformationList = stationInformationList :+ stationInformationJSON.toModel
  }

  //val stationInformationString = stationInformationList.map(x => x + ",")


  /** REMOVE ANY UNNCESSARY HDFS PATHS **/
  //  HDFS.remove(Constants.HDFS_STATION_STATUS)
  //  HDFS.remove(Constants.HDFS_SYSTEM_ALERTS)
  //  HDFS.remove(Constants.HDFS_SYSTEM_INFORMATION)
  //  HDFS.remove(Constants.HDFS_STATION_INFORMATION)

  /** WRITE JSON TO HDFS **/
//  HDFS.write(Constants.HDFS_STATION_STATUS_JSON, stationStatusData)
//  HDFS.write(Constants.HDFS_SYSTEM_ALERTS_JSON, systemAlertsData)
//  HDFS.write(Constants.HDFS_SYSTEM_INFORMATION_JSON, systemInformationData)
//  HDFS.write(Constants.HDFS_STATION_INFORMATION_JSON, stationInformationData)

  /** READ JSON FILES FROM HDFS AND CONVERT TO DATAFRAME **/
//  val stationStatusDataFrame = HDFS.read(Constants.HDFS_STATION_STATUS_JSON, Constants.FORMAT_JSON, Constants.STATION_STATUS_COLUMNS)
//  val systemAlertsDataFrame = HDFS.read(Constants.HDFS_SYSTEM_ALERTS_JSON, Constants.FORMAT_JSON, Constants.SYSTEM_ALERTS_COLUMNS)
//  val systemInformationDataFrame = HDFS.read(Constants.HDFS_SYSTEM_INFORMATION_JSON, Constants.FORMAT_JSON, Constants.SYSTEM_INFORMATION_COLUMNS)
//  val stationInformationDataFrame = HDFS.read(Constants.HDFS_STATION_INFORMATION_JSON, Constants.FORMAT_JSON, Constants.STATION_INFORMATION_COLUMNS)

  /** WRITE BACK TO HDFS IN CSV FORMAT **/
//  stationStatusDataFrame.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.HDFS_STATION_STATUS)
//  systemAlertsDataFrame.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.HDFS_SYSTEM_ALERTS)
//  systemInformationDataFrame.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.HDFS_SYSTEM_INFORMATION)
//  stationInformationDataFrame.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.HDFS_STATION_INFORMATION)

}
