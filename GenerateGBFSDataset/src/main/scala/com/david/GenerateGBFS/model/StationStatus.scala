package com.david.GenerateGBFS.model

case class StationStatus(station_id: String,
                         num_bikes_available: Int,
                         num_ebikes_available: Int,
                         num_bikes_disabled: Int,
                         num_docks_available: Int,
                         num_docks_disabled: Int,
                         is_installed: Int,
                         is_renting: Int,
                         is_returning: Int,
                         last_reported: Long,
                         eightd_has_available_keys: Boolean) extends MODEL{

}
