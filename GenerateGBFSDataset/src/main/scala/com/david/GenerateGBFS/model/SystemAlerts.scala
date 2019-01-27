package com.david.GenerateGBFS.model

case class SystemAlerts(alert_id: String,
                        `type`: String,
                        summary: String,
                        description: String,
                        last_updated: Long) extends MODEL{

}
