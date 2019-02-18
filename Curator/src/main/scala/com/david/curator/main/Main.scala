package com.david.curator.main

import java.util.Collections

import com.david.curator.connection.SparkConnection
import com.david.curator.kafka.Kafka
import com.david.curator.util.Constants

object Main extends App{

  //val kafkaConsumer = Kafka.createConsumer

  //kafkaConsumer.subscribe(Collections.singleton(Constants.ENRICH_TOPIC))

  SparkConnection.getSparkSession.sql("use bixi_feed")
  SparkConnection.getSparkSession.sql("select * from ext_station_status")

  //SparkConnection.getSparkSession.sql("show databases").show

  //SparkConnection.getSparkStreaming.start()
  //SparkConnection.getSparkStreaming.awaitTermination()

}
