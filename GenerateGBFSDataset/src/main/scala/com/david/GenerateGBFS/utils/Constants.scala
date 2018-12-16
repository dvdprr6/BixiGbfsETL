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
  val HDFS_STATION_INFORMATION_JSON = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/station_information.json"

  val STREAMING_INTERVAL = 5

  val FORMAT_CSV = "csv"
  val FORMAT_JSON = "json"

  val STATION_STATUS_COLUMNS = Seq("station_id", "num_bikes_available", "num_ebikes_available", "num_bikes_disabled", "num_docks_available", "num_docks_disabled", "is_installed", "is_renting", "is_returning", "last_reported", "eightd_has_available_keys")
  val SYSTEM_INFORMATION_COLUMNS = Seq("system_id", "language", "name", "short_name", "operator", "url", "purchase_url", "start_date", "phone_number", "email", "license_url", "timezone")
  val STATION_INFORMATION_COLUMNS = Seq("station_id", "name", "short_name", "lat", "lon", "rental_methods", "capacity", "eightd_has_key_dispenser", "has_kiosk")

  val DELIMITER = ";"
}
