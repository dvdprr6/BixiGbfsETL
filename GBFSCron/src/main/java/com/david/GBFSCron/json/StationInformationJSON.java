package com.david.GBFSCron.json;

import com.david.GBFSCron.model.StationInformation;
import com.david.GBFSCron.utils.JSONParser;
import org.json.JSONObject;

import java.util.List;

public class StationInformationJSON {
    public String station_id;
    public String external_id;
    public String name;
    public String short_name;
    public String lat;
    public String lon;
    public List<String> rental_methods;
    public Integer capacity;
    public Boolean eightd_has_key_dispenser;
    public Boolean has_kiosk;

    public JSONObject toJSON(){
        return JSONParser.toJSON(this.getClass(), this);
    }

    public StationInformation toModel(){
        StationInformation stationInformation = new StationInformation();
        stationInformation.setStationId(station_id);
        stationInformation.setExternalId(external_id);
        stationInformation.setName(name);
        stationInformation.setShortName(short_name);
        stationInformation.setLat(lat);
        stationInformation.setLon(lon);
        stationInformation.setRentalMethods(rental_methods);
        stationInformation.setCapacity(capacity);
        stationInformation.setEightdHasKeyDispenser(eightd_has_key_dispenser);
        stationInformation.setHasKiosk(has_kiosk);

        return stationInformation;
    }
}
