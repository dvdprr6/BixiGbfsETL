package com.david.GenerateGBFS.hadoop

import java.net.URI

import com.david.GenerateGBFS.spark.SparkConnection
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.conf.Configuration
import org.apache.spark.sql.DataFrame

object HDFS {

  def readFromHdfs(hdfsPath: String, fileFormat: String): DataFrame = {
    return SparkConnection.getSparkSession.read.format(fileFormat).load(hdfsPath)
  }

  def readFromHdfs(hdfsPath: String, fileFormat: String, columns: Seq[String]): DataFrame = {
    val dataFrame = SparkConnection.getSparkSession.read.format(fileFormat).load(hdfsPath)
    val selectColumns = columns.map(name => dataFrame.col(name))

    return dataFrame.select(selectColumns:_*)
  }

  val writeToHdfs = (hdfsPath: String, content: String) => {
    val path = new Path(hdfsPath)

    val fs = FileSystem.get(new URI(hdfsPath), new Configuration())

    if(fs.exists(path)){
      fs.delete(path, true)
    }

    val dataOutputStream = fs.create(path)
    dataOutputStream.write(content.getBytes)
    fs.close()
  }

  val remove = (hdfsPath: String) => {
    val path = new Path(hdfsPath)
    val fs = FileSystem.get(new URI(hdfsPath), new Configuration())
    if(fs.exists(path)){
      fs.delete(path, true)
    }
    fs.close()
  }
}
