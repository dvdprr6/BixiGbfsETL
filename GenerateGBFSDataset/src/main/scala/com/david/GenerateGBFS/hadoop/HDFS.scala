package com.david.GenerateGBFS.hadoop

import java.net.URI

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.conf.Configuration

object HDFS {

  def write(hdfsPath: String, content: String): Unit = {
    val path = new Path(hdfsPath)
    val fs = FileSystem.get(new URI(hdfsPath), getConfiguration())
    if(fs.exists(path)){
      fs.delete(path, true)
    }

    val dataOutputStream = fs.create(path)
    dataOutputStream.write(content.getBytes)
    fs.close()
  }

  def remove(hdfsPath: String): Unit = {
    val path = new Path(hdfsPath)
    val fs = FileSystem.get(new URI(hdfsPath), getConfiguration())
    if(fs.exists(path)){
      fs.delete(path, true)
    }
    fs.close()
  }

  private def getConfiguration(): Configuration = {
    val configuration  = new Configuration()
    configuration.set("fs.hdfs.impl", classOf[org.apache.hadoop.hdfs.DistributedFileSystem].getName)
    configuration.set("fs.file.impl", classOf[org.apache.hadoop.fs.LocalFileSystem].getName)

    return configuration
  }
}
