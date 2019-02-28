package com.david.curator.main

import com.david.curator.connection.SparkConnection
import com.david.curator.util.{Constants, SchemaGeneration}
import com.david.curator.stream.Stream

object Main extends App{

  val enrichFile = SparkConnection.getSparkStreaming.textFileStream(Constants.ENRICH_CSV_FILE_STREAMING)

  val enrichDS = Stream.streamEnrichCSVFile(enrichFile)

  val schema = SchemaGeneration.getSchema(Constants.ENRICH_CSV_SCHEMA)

  SparkConnection.getSparkSession.sql("use bixi_feed")

  enrichDS.foreachRDD{rdd =>
    val enrichDF = SparkConnection.getSparkSession.createDataFrame(rdd, schema)

    enrichDF.foreachPartition{partition =>

      partition.foreach { record =>
        val startStationId = record.getAs[String]("start_station_id")
        val endStationId = record.getAs[String]("end_station_id")

        val startStationStatusDF = SparkConnection.getSparkSession.sql("select * from ext_station_status where station_id = " + startStationId)
        val endStationStatusDF = SparkConnection.getSparkSession.sql("select * from ext_station_status where station_id = " + endStationId)

      }
    }
  }


  SparkConnection.getSparkStreaming.start()
  SparkConnection.getSparkStreaming.awaitTermination()
}
