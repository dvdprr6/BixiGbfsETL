# Generate GBFS Datasets

## Introduction
Using Spark Streaming and Bixi's GBFS data, which can be found [here](https://api-core.bixi.com/gbfs/gbfs.json). This application will download system_alerts.json, system_information.json, station_status.json, and station_information.json and convert the json data to csv and save it on HDFS.

## Scripts

The following script can be used to run the application ```generateGBFSDataset.sh```

```
#!/bin/bash

# FOR DEBUGGING
#export SPARK_SUBMIT_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5000

spark-submit --class com.david.GenerateGBFS.main.Main --master local[*] GenerateGBFSDataset.jar
```

The script that creates the hive tables can be found [here](https://github.com/dvdprr6/BixiGbfsETL/blob/master/install/createTables.sql)

## system_alerts.json
This dataset shows the status of the whole Bixi system. Since the Bixi service has ended for the winter it now states that the system is closed; [system_alerts.json](https://api-core.bixi.com/gbfs/en/system_alerts.json)

## system_information.json
Displays the information of the Bixi system; [system_information.json](https://api-core.bixi.com/gbfs/en/system_information.json)

## station_status.json and station_information.json

The two datatsets [station_status.json](https://api-core.bixi.com/gbfs/en/station_status.json) and [station_information.json](https://api-core.bixi.com/gbfs/en/station_information.json) have a one-to-one relationship, they can be matched on ```station_id```.

```station_status.json``` displays the current status of the individual stations, for example the number of bikes available and total capacity. ```station_information.json``` displays the information at each station, where it is located (lat and lon) in the city and the station code (short_name).

```station_information.json``` has a column or key called ```short_name```. This column or key represents the code of the station. This allows a one-to-one relationship with the static data (Trip History), for example if we take Trip History for the Year 2018, we can see the relationship with ```Stations_2018.csv```. This relationship will then allow us find the trip history between the months from March to November of 2018.

## Diagram

## References
1. Bixi open data: https://www.bixi.com/en/open-data
2. GBFS Feed: https://api-core.bixi.com/gbfs/gbfs.json
3. GBFS documentation: https://github.com/NABSA/gbfs/blob/master/gbfs.md
