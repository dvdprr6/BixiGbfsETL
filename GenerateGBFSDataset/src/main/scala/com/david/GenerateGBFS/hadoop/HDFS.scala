package com.david.GenerateGBFS.hadoop

import java.net.URI

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.conf.Configuration

object HDFS {

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
}
