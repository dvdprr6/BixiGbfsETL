package com.david.curator.util

import org.apache.spark.sql.types.{StringType, StructField, StructType}

object SchemaGeneration {
  val getSchema = (schemaString: String) => {
    StructType(schemaString.split(Constants.DELIMITER).map(fieldName => StructField(fieldName, StringType, true)))
  }
}
