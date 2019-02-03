package com.david.GenerateGBFS.utils

object Constants {
  val APP_NAME = "GenerateGBFSDataset"

  val STATION_STATUS_JSON = "https://api-core.bixi.com/gbfs/en/station_status.json"
  val SYSTEM_ALERTS_JSON = "https://api-core.bixi.com/gbfs/en/system_alerts.json"
  val SYSTEM_INFORMATION_JSON = "https://api-core.bixi.com/gbfs/en/system_information.json"
  val STATION_INFORMATION_JSON = "https://api-core.bixi.com/gbfs/en/station_information.json"

  val HDFS_STATION_STATUS = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/staging/feed/station_status/station_status.csv"
  val HDFS_SYSTEM_ALERTS = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/staging/feed/system_alerts/system_alerts.csv"
  val HDFS_SYSTEM_INFORMATION = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/staging/feed/system_information/system_information.csv"
  val HDFS_STATION_INFORMATION = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/staging/feed/station_information/station_information.csv"

  val HDFS_STATION_STATUS_JSON = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/station_status.json"
  val HDFS_SYSTEM_ALERTS_JSON = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/system_alerts.json"
  val HDFS_SYSTEM_INFORMATION_JSON = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/system_information.json"
  val HDFS_STATION_INFORMATION_JSON = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/json/station_information.json"

  val STREAMING_INTERVAL = 5

  val FORMAT_CSV = "csv"
  val FORMAT_JSON = "json"

  val STATION_STATUS_COLUMNS = "station_id;num_bikes_available;num_ebikes_available;num_bikes_disabled;num_docks_available;num_docks_disabled;is_installed;is_renting;is_returning;last_reported;eightd_has_available_keys\n"
  val SYSTEM_INFORMATION_COLUMNS = "system_id;language;name;short_name;operator;url;purchase_url;start_date;phone_number;email;license_url;timezone\n"
  val STATION_INFORMATION_COLUMNS = "station_id;external_id;name;short_name;lat;lon;rental_methods_0;rental_methods_1;capacity;eightd_has_key_dispenser;has_kiosk\n"
  val SYSTEM_ALERTS_COLUMNS = "alert_id;type;summary;description;last_updated\n"

  val DELIMITER = ";"
}
