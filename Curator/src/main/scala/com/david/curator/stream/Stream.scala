package com.david.curator.stream

import com.david.curator.util.Constants
import org.apache.spark.sql.Row
import org.apache.spark.streaming.dstream.DStream

object Stream {

  val streamEnrichCSVFile = (stream: DStream[String]) => {
    stream.map(_.split(Constants.DELIMITER)).map(enrich =>
      Row(
        enrich(0),
        enrich(1),
        enrich(2),
        enrich(3),
        enrich(4),
        enrich(5),
        enrich(6),
        enrich(7),
        enrich(8),
        enrich(9),
        enrich(10),
        enrich(11),
        enrich(12),
        enrich(13),
        enrich(14),
        enrich(15),
        enrich(16),
        enrich(17),
        enrich(18),
        enrich(19),
        enrich(20),
        enrich(21),
        enrich(22),
        enrich(23),
        enrich(24),
        enrich(25),
        enrich(26),
        enrich(27),
        enrich(28),
        enrich(29)
      )
    )
  }

}
