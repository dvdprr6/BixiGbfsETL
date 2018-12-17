use bixi_feed;

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
LOCATION '/user/vagrant/bixi/gbfs/staging/system_information'

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
LOCATION '/user/vagrant/bixi/gbfs/staging/system_information'