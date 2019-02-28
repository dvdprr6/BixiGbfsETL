package com.david.curator.util

object Constants {
  val APP_NAME = "Curator"

  val ENRICH_TOPIC = "enrich_trip"
  val CURATOR_TOPIC = "curator"
  val BOOTSTRAP_SERVERS = "localhost:9092"
  val SCHEMA_REGISTRY_URL = "http://localhost:8081"

  val STREAMING_INTERVAL = 1

  val ENRICH_CSV_FILE_STREAMING = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/csv/enrich/streaming/";

  val DELIMITER = ";"

  val ENRICH_CSV_SCHEMA = "start_date" + DELIMITER +
    "start_station_code" + DELIMITER +
    "start_station_id" + DELIMITER +
    "start_external_id"+ DELIMITER +
    "start_name" + DELIMITER +
    "start_short_name" + DELIMITER +
    "start_lat" + DELIMITER +
    "start_lon" + DELIMITER +
    "start_rental_methods0" + DELIMITER +
    "start_rental_methods1" + DELIMITER +
    "start_capacity" + DELIMITER +
    "start_eightd_has_key_dispenser" + DELIMITER +
    "start_has_kiosk" + DELIMITER +
    "start_google_api_geocoding_json" + DELIMITER +
    "end_date" + DELIMITER +
    "end_station_code" + DELIMITER +
    "end_station_id" + DELIMITER +
    "end_external_id" + DELIMITER +
    "end_name" + DELIMITER +
    "end_short_name" + DELIMITER +
    "end_lat" + DELIMITER +
    "end_lon" + DELIMITER +
    "end_rental_methods0" + DELIMITER +
    "end_rental_methods1" + DELIMITER +
    "end_capacity" + DELIMITER +
    "end_eightd_has_key_dispenser" + DELIMITER +
    "end_has_kiosk" + DELIMITER +
    "end_google_api_geocoding_json" + DELIMITER +
    "duration_sec" + DELIMITER +
    "is_memember"
}
