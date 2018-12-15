package com.david.GenerateGBFS.main

import com.david.GenerateGBFS.hadoop.HDFS
import com.david.GenerateGBFS.httpclient.HttpConnection
import com.david.GenerateGBFS.spark.SparkConnection
import com.david.GenerateGBFS.utils.Constants

object Main extends App{
  // try using dataframes to convert JSON to CSV

  /** MAKE GET REQUEST TO RETRIEVE JSON **/
  val stationStatusResponse = HttpConnection.sendHttpGet(Constants.STATION_STATUS_JSON)
  val systemAlertsResponse = HttpConnection.sendHttpGet(Constants.SYSTEM_ALERTS_JSON)
  val systemInformationResponse = HttpConnection.sendHttpGet(Constants.SYSTEM_INFORMATION_JSON)
  val stationInformationResponse = HttpConnection.sendHttpGet(Constants.STATION_INFORMATION_JSON)



  //stationInformationResponse.save

  /** WRITE JSON TO HDFS **/
  HDFS.writeToHdfs(Constants.HDFS_STATION_STATUS_JSON, stationStatusResponse)
  HDFS.writeToHdfs(Constants.HDFS_SYSTEM_ALERTS_JSON, systemAlertsResponse)
  HDFS.writeToHdfs(Constants.HDFS_SYSTEM_INFORMATION_JSON, systemInformationResponse)
  HDFS.writeToHdfs(Constants.HDFS_JSON_STATION_INFORMATION, stationInformationResponse)

  //val df = SparkConnection.getSparkSession.read.json(SparkConnection.getSparkSession.sparkContext.parallelize(stationInformationResponse))
  //val rdd = SparkConnection.getSparkSession.sparkContext.parallelize(Seq(stationInformationResponse))
  //val df = SparkConnection.getSparkSession.sqlContext.read.js

}
