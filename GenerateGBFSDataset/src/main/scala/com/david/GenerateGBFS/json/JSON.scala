package com.david.GenerateGBFS.json

import com.david.GenerateGBFS.model.MODEL
import org.json.JSONObject

trait JSON [T <: MODEL] {
  def toJSON: JSONObject
  def toModel: T
}
