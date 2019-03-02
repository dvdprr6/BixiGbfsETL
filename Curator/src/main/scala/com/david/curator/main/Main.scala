package com.david.curator.main

import com.david.curator.connection.SparkConnection
import com.david.curator.util.{Constants, SchemaGeneration}
import com.david.curator.stream.Stream
import org.apache.spark.sql.functions.col

object Main extends App{

  val enrichFile = SparkConnection.getSparkStreaming.textFileStream(Constants.ENRICH_CSV_FILE_STREAMING)

  val enrichDS = Stream.streamEnrichCSVFile(enrichFile)

  val schema = SchemaGeneration.getSchema(Constants.ENRICH_CSV_SCHEMA)

  SparkConnection.getSparkSession.sql("use bixi_feed")

//  enrichDS.foreachRDD{rdd =>
//    val enrichDF = SparkConnection.getSparkSession.createDataFrame(rdd, schema)
//
//    enrichDF.foreachPartition{partition =>
//
//      partition.foreach { record =>
//        //val startStationId = record.getAs[String]("start_station_id")
//        //val endStationId = record.getAs[String]("end_station_id")
//
//        //val startStationStatusDF = SparkConnection.getSparkSession.sql("select * from ext_station_status where station_id = " + startStationId)
//        //val endStationStatusDF = SparkConnection.getSparkSession.sql("select * from ext_station_status where station_id = " + endStationId)
//
//        val stationStatusDF = SparkConnection.getSparkSession.sql("select * from ext_station_status")
//
//        //
//
//      }
//    }
//  }

  enrichDS.foreachRDD{rdd =>
    val enrichDF = SparkConnection.getSparkSession.createDataFrame(rdd, schema)

    val stationStatusDF = SparkConnection.getSparkSession.sql("select * from ext_station_status")

    val startEnrichColumns = Constants.ENRICH_START_COLUMNS.map(name => enrichDF.col(name))
    val endEnrichColumns = Constants.ENRICH_END_COLUMNS.map(name => enrichDF.col(name))

    val startEnrichDF = enrichDF.select(startEnrichColumns:_*)
    val endEnrichDF = enrichDF.select(endEnrichColumns:_*)

    val startCurateDF = startEnrichDF.join(stationStatusDF, col(Constants.ENRICH_COLUMN_START_STATION_ID) === col(Constants.STATION_STATUS_COLUMN_STATION_ID), "inner")
    val endCurateDF = endEnrichDF.join(stationStatusDF, col(Constants.ENRICH_COLUMN_END_STATION_ID) === col(Constants.STATION_STATUS_COLUMN_STATION_ID), "inner")


    if(!startCurateDF.take(1).isEmpty){
      startCurateDF.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.CURATE_START_STATION_STATUS)
    }

    if(!endCurateDF.take(1).isEmpty){
      endCurateDF.rdd.map(x => x.mkString(Constants.DELIMITER)).saveAsTextFile(Constants.CURATE_END_STATION_STATUS)
    }

  }

  SparkConnection.getSparkStreaming.start()
  SparkConnection.getSparkStreaming.awaitTermination()
}
