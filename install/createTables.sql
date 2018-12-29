use bixi_feed;

CREATE EXTERNAL TABLE IF NOT EXISTS ext_station_status(
  station_id                  STRING,
  num_bikes_available         INTEGER,
  num_ebikes_available        INTEGER,
  num_bikes_disabled          INTEGER,
  num_docks_available         INTEGER,
  num_docks_disabled          INTEGER,
  is_installed                INTEGER,
  is_renting                  INTEGER,
  is_returning                INTEGER,
  last_reported               BIGINT,
  eightd_has_available_keys   BOOLEAN
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/feed/station_status';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_system_alerts(
  alert_id      STRING,
  type          STRING,
  summary       STRING,
  description   STRING,
  last_updated  BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/feed/system_alerts';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_system_information(
  system_id     STRING,
  language      STRING,
  name          STRING,
  short_name    STRING,
  operator      STRING,
  url           STRING,
  purchase_url  STRING,
  start_date    STRING,
  phone_number  STRING,
  email         STRING,
  license_url   STRING,
  timezone      STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/feed/system_information';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_station_information(
  station_id                STRING,
  name                      STRING,
  short_name                STRING,
  lat                       DOUBLE,
  lon                       DOUBLE,
  rental_methods            STRING,
  capacity                  INTEGER,
  eightd_has_key_dispenser  BOOLEAN,
  has_kiosk                 BOOLEAN
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/feed/station_information';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_OD_2018_04(
  start_date          STRING,
  start_station_code  INTEGER,
  end_date            STRING,
  end_station_code    INTEGER,
  duration_sec        INTEGER,
  is_member           INTEGER
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/OD_2018-04';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_OD_2018_05(
  start_date          STRING,
  start_station_code  INTEGER,
  end_date            STRING,
  end_station_code    INTEGER,
  duration_sec        INTEGER,
  is_member           INTEGER
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/OD_2018-05';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_OD_2018_06(
  start_date          STRING,
  start_station_code  INTEGER,
  end_date            STRING,
  end_station_code    INTEGER,
  duration_sec        INTEGER,
  is_member           INTEGER
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/OD_2018-06';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_OD_2018_07(
  start_date          STRING,
  start_station_code  INTEGER,
  end_date            STRING,
  end_station_code    INTEGER,
  duration_sec        INTEGER,
  is_member           INTEGER
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/OD_2018-07';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_OD_2018_08(
  start_date          STRING,
  start_station_code  INTEGER,
  end_date            STRING,
  end_station_code    INTEGER,
  duration_sec        INTEGER,
  is_member           INTEGER
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/OD_2018-08';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_OD_2018_09(
  start_date          STRING,
  start_station_code  INTEGER,
  end_date            STRING,
  end_station_code    INTEGER,
  duration_sec        INTEGER,
  is_member           INTEGER
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/OD_2018-09';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_OD_2018_10(
  start_date          STRING,
  start_station_code  INTEGER,
  end_date            STRING,
  end_station_code    INTEGER,
  duration_sec        INTEGER,
  is_member           INTEGER
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/OD_2018-10';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_OD_2018_11(
  start_date          STRING,
  start_station_code  INTEGER,
  end_date            STRING,
  end_station_code    INTEGER,
  duration_sec        INTEGER,
  is_member           INTEGER
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/OD_2018-11';

CREATE EXTERNAL TABLE IF NOT EXISTS ext_stations_2018(
  code          INTEGER,
  name          STRING,
  latitude      DOUBLE,
  longitude     DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/vagrant/bixi/gbfs/staging/static/Stations_2018';