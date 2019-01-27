package com.david.GenerateGBFS.json

import com.david.GenerateGBFS.model.SystemAlerts
import org.json.JSONObject
import org.json4s.jackson.JsonMethods.{compact, render}
import org.json4s.JsonDSL._

class SystemAlertsJSON(alert_id: String,
                       `type`: String,
                       summary: String,
                       description: String,
                       last_updated: Long) extends JSON[SystemAlerts]{

  override def toJSON: JSONObject = {
    val json = ("alert_id" -> alert_id) ~
      ("type" -> `type`) ~
      ("summary" -> summary) ~
      ("description" -> description) ~
      ("last_updated" -> last_updated)

    val compactJson = compact((render(json)))

    return new JSONObject(compactJson)
  }

  override def toModel: SystemAlerts = {
    return new SystemAlerts(alert_id, `type`, summary, description, last_updated)
  }
}
