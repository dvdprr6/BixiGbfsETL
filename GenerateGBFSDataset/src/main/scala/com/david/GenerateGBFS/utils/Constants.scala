package com.david.GenerateGBFS.utils

object Constants {
  val APP_NAME = "GenerateGBFSDataset"

  val STATION_STATUS_JSON = "https://api-core.bixi.com/gbfs/en/station_status.json"
  val SYSTEM_ALERTS_JSON = "https://api-core.bixi.com/gbfs/en/system_alerts.json"
  val SYSTEM_INFORMATION_JSON = "https://api-core.bixi.com/gbfs/en/system_information.json"
  val STATION_INFORMATION_JSON = "https://api-core.bixi.com/gbfs/en/station_information.json"

  val HDFS_STATION_STATUS = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/staging/station_status"
  val HDFS_SYSTEM_ALERTS = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/staging/system_alerts"
  val HDFS_SYSTEM_INFORMATION = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/staging/system_information"
  val HDFS_STATION_INFORMATION = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/staging/station_information"

  val HDFS_STATION_STATUS_JSON = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/station_status.json"
  val HDFS_SYSTEM_ALERTS_JSON = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/system_alerts.json"
  val HDFS_SYSTEM_INFORMATION_JSON = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/system_information.json"
  val HDFS_JSON_STATION_INFORMATION = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/station_information.json"
}
