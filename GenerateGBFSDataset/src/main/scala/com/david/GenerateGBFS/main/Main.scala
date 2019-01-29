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

  /** REMOVE ANY UNNCESSARY HDFS PATHS **/
  HDFS.remove(Constants.HDFS_STATION_STATUS)
  HDFS.remove(Constants.HDFS_SYSTEM_ALERTS)
  HDFS.remove(Constants.HDFS_SYSTEM_INFORMATION)
  HDFS.remove(Constants.HDFS_STATION_INFORMATION)

  /* BUILD CSV */

  val stringBuilderStationStatus = new StringBuilder(Constants.STATION_STATUS_COLUMNS)
  stationStatusList.map(stationStatus => {
    stringBuilderStationStatus.append(stationStatus.asInstanceOf[StationStatus].station_id
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].num_bikes_available
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].num_ebikes_available
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].num_bikes_disabled
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].num_docks_available
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].num_docks_disabled
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].is_installed
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].is_renting
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].is_returning
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].last_reported
      + Constants.DELIMITER + stationStatus.asInstanceOf[StationStatus].eightd_has_available_keys + "\n")
  })

  HDFS.write(Constants.HDFS_STATION_STATUS, stringBuilderStationStatus.toString())
  stringBuilderStationStatus.clear()

  val stringBuilderSystemAlerts = new StringBuilder(Constants.SYSTEM_ALERTS_COLUMNS)
  systemAlertsList.map(systemAlerts => {
    stringBuilderSystemAlerts.append(systemAlerts.asInstanceOf[SystemAlerts].alert_id
      + Constants.DELIMITER + systemAlerts.asInstanceOf[SystemAlerts].`type`
      + Constants.DELIMITER + systemAlerts.asInstanceOf[SystemAlerts].summary
      + Constants.DELIMITER + systemAlerts.asInstanceOf[SystemAlerts].description
      + Constants.DELIMITER + systemAlerts.asInstanceOf[SystemAlerts].last_updated + "\n")
  })

  HDFS.write(Constants.HDFS_SYSTEM_ALERTS, stringBuilderSystemAlerts.toString)
  stringBuilderSystemAlerts.clear

  val stringBuilderSystemInformation = new StringBuilder(Constants.SYSTEM_INFORMATION_COLUMNS)
    .append(systemInformationModel.asInstanceOf[SystemInformation].system_id
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].language
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].name
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].short_name
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].name
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].short_name
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].operator
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].url
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].purchase_url
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].start_date
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].phone_number
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].email
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].license_url
      + Constants.DELIMITER + systemInformationModel.asInstanceOf[SystemInformation].timezone + "\n")

  HDFS.write(Constants.HDFS_SYSTEM_INFORMATION, stringBuilderSystemInformation.toString)
  stringBuilderSystemInformation.clear

  val stringBuilderStationInformation = new StringBuilder(Constants.STATION_INFORMATION_COLUMNS)
  stationInformationList.map(stationInformation => {
    stringBuilderStationInformation.append(stationInformation.asInstanceOf[StationInformation].station_id
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].external_id
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].name
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].short_name
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].lat
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].lon
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].rental_methods(0)
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].rental_methods(1)
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].capacity
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].eightd_has_key_dispenser
      + Constants.DELIMITER + stationInformation.asInstanceOf[StationInformation].has_kiosk + "\n")
  })

  HDFS.write(Constants.HDFS_STATION_INFORMATION, stringBuilderStationInformation.toString)
  stringBuilderStationInformation.clear

}
