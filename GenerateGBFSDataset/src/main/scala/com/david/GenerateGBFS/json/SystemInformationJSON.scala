package com.david.GenerateGBFS.json

import com.david.GenerateGBFS.model.{StationInformation, SystemInformation}
import org.json.JSONObject
import org.json4s.jackson.JsonMethods.{compact, render}
import org.json4s.JsonDSL._

class SystemInformationJSON(system_id: String,
                            language: String,
                            name: String,
                            short_name: String,
                            operator: String,
                            url: String,
                            purchase_url: String,
                            start_date: String,
                            phone_number: String,
                            email: String,
                            license_url: String,
                            timezone: String) extends JSON[SystemInformation]{

  override def toJSON: JSONObject = {
    val json = ("system_id" -> system_id) ~
      ("language" -> language) ~
      ("name" -> name) ~
      ("short_name" -> short_name) ~
      ("operator" -> operator) ~
      ("url" -> url) ~
      ("purchase_url" -> purchase_url)
      ("start_date" -> start_date) ~
      ("phone_number" -> phone_number) ~
      ("email" -> email) ~
      ("license_url" -> license_url) ~
      ("timezone" -> timezone)

    val compactJson = compact((render(json)))

    return new JSONObject(compactJson)
  }

  override def toModel: SystemInformation = {
    return new SystemInformation(system_id, language, name, short_name, operator, url, purchase_url, start_date, phone_number, email, license_url, timezone)
  }
}
