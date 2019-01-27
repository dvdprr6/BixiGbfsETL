package com.david.GenerateGBFS.utils

import com.david.GenerateGBFS.json.JSON
import com.david.GenerateGBFS.model.MODEL
import org.json4s._
import org.json4s.jackson.JsonMethods._
object JSONParser {
  implicit val formats = DefaultFormats

  def parseJSON[T <: JSON[_ <: MODEL] : Manifest](json: String, clazz: Class[_ <: MODEL]): JSON[_ <: MODEL] = { // Use Manifest if you want to pass the object directly
    return parse(json).extract[T]
  }
}
