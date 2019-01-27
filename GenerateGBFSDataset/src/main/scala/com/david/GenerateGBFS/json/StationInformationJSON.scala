package com.david.GenerateGBFS.json

import com.david.GenerateGBFS.model.StationInformation
import org.json.JSONObject
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

class StationInformationJSON(station_id: String,
                             external_id: String,
                             name: String,
                             short_name: String,
                             lat: String,
                             lon: String,
                             rental_methods: List[String],
                             capacity: Int,
                             eightd_has_key_dispenser: Boolean,
                             has_kiosk: Boolean) extends JSON[StationInformation] {


  override def toJSON: JSONObject = {
    val json = ("station_id" -> station_id) ~
      ("external_id" -> external_id) ~
      ("name" -> name) ~
      ("short_name" -> short_name) ~
      ("lat" -> lat) ~
      ("lon" -> lon) ~
      ("rental_methods" -> rental_methods)
      ("capacity" -> capacity) ~
      ("eightd_has_key_dispenser" -> eightd_has_key_dispenser) ~
      ("has_kiosk" -> has_kiosk)

    val compactJson = compact((render(json)))

    return new JSONObject(compactJson)
  }

  override def toModel: StationInformation = {
    return new StationInformation(station_id, external_id, name, short_name, lat, lon, rental_methods, capacity, eightd_has_key_dispenser, has_kiosk)
  }
}

