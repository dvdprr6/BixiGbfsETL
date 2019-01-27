package com.david.GenerateGBFS.model

case class StationInformation(station_id: String,
                              external_id: String,
                              name: String,
                              short_name: String,
                              lat: String,
                              lon: String,
                              rental_methods: List[String],
                              capacity: Int,
                              eightd_has_key_dispenser: Boolean,
                              has_kiosk: Boolean) extends MODEL{

}
