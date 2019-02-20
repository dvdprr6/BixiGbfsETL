package com.david.curator.main

import java.util.Collections

import com.david.avro.EnrichedTrip
import com.david.curator.connection.SparkConnection
import com.david.curator.kafka.Kafka
import com.david.curator.util.Constants

object Main extends App{
  Thread.sleep(5000)
  //val kafkaConsumer = Kafka.createConsumer

  //kafkaConsumer.subscribe(Collections.singleton(Constants.ENRICH_TOPIC))

  //SparkConnection.getSparkSession.sql("use bixi_feed")
  //SparkConnection.getSparkSession.sql("select * from ext_station_status")

  //SparkConnection.getSparkSession.sql("show databases").show

  //SparkConnection.getSparkStreaming.start()
  //SparkConnection.getSparkStreaming.awaitTermination()
  val enrichTripDS = Kafka.createConsumerStream

  enrichTripDS.foreachRDD{ rdd =>
    //rdd.foreach(enrichTrip => println(enrichTrip.getTripHistory.getStartStationCode))
    //val enrichTripDF = SparkConnection.getSparkSession.createDataFrame(rdd, EnrichedTrip.getClassSchema)
  }


  SparkConnection.getSparkStreaming.start()
  SparkConnection.getSparkStreaming.awaitTermination()

}
