package com.david.GenerateGBFS.json
import com.david.GenerateGBFS.model.StationStatus
import org.json.JSONObject
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

class StationStatusJSON(station_id: String,
                        num_bikes_available: Int,
                        num_ebikes_available: Int,
                        num_bikes_disabled: Int,
                        num_docks_available: Int,
                        num_docks_disabled: Int,
                        is_installed: Int,
                        is_renting: Int,
                        is_returning: Int,
                        last_reported: Long,
                        eightd_has_available_keys: Boolean) extends JSON[StationStatus]{

  override def toJSON: JSONObject = {
    val json = ("station_id" -> station_id) ~
      ("num_bikes_available" -> num_bikes_available) ~
      ("num_ebikes_available" -> num_ebikes_available) ~
      ("num_bikes_disabled" -> num_bikes_disabled) ~
      ("num_docks_available" -> num_docks_available) ~
      ("num_docks_disabled" -> num_docks_disabled) ~
      ("is_installed" -> is_installed)
      ("is_renting" -> is_renting) ~
      ("is_returning" -> is_returning) ~
      ("last_reported" -> last_reported) ~
      ("eightd_has_available_keys" -> eightd_has_available_keys)

    val campactJson = compact((render(json)))

    return new JSONObject(campactJson)
  }

  override def toModel: StationStatus = {
    return new StationStatus(station_id, num_bikes_available, num_ebikes_available, num_bikes_disabled, num_docks_available, num_docks_disabled, is_installed, is_renting, is_returning, last_reported, eightd_has_available_keys)
  }
}
