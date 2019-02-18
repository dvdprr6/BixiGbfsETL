package com.david.curator.connection

import com.david.curator.util.Constants
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkConnection {
  // NOTE: don't forget to copy hive-site.xml to spark-*/conf
  private lazy val session: SparkSession = SparkSession.builder().appName(Constants.APP_NAME).config("spark.sql.warehouse.dir", "/user/hive/warehouse").enableHiveSupport().getOrCreate()
  private lazy val context: SparkContext = session.sparkContext
  private lazy val streaming: StreamingContext = new StreamingContext(context, Seconds(Constants.STREAMING_INTERVAL))

  lazy val getSparkSession: SparkSession = session
  lazy val getSparkStreaming: StreamingContext = streaming

  lazy val closeSparkSession: Unit = session.close
}
