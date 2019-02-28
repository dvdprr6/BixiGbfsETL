package com.david.enricher.utils;

public class Constants {
    public static final String HBASE_BIXI_GBFS_TABLE = "BIXI:GBFS";
    public static final String HBASE_COLUMN_FAMILY_STATION_INFORMATION = "STATION_INFORMATION";
    public static final String HBASE_COLUMN_FAMILY_GOOGLE_GEOCODING = "GOOGLE_GEOCODING";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_STATION_ID = "station_id";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_EXTERNAL_ID = "external_id";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_NAME = "name";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_SHORT_NAME = "short_name";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_LAT = "lat";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_LON = "lon";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_RENTAL_METHODS_0 = "rental_methods_0";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_RENTAL_METHODS_1 = "rental_methods_1";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_CAPACITY = "capacity";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_EIGHTD_HAS_KEY_DISPENCER = "eightd_has_key_dispenser";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_HAS_KIOSK = "has_kiosk";
    public static final String HBASE_STATION_INFORMATION_QUALIFIER_GOOGLE_GEOCODING = "google_api_geocoding_json";

    public static final String TRIP_HISTORY_TOPIC = "trip_history";
    public static final String BOOTSTRAP_SERVERS = "localhost:9092";
    public static final String SCHEMA_REGISTRY_URL = "http://localhost:8081";

    public static final String DELIMITER = ";";

    public static final String ENRICH_CSV_FILE_STAGING = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/csv/enrich/staging/enrich.csv";
    public static final String ENRICH_CSV_FILE_STREAMING = "hdfs://localhost:9000/user/vagrant/bixi/gbfs/csv/enrich/streaming/enrich.csv";
}
