package com.david.GBFSCron.json;

import com.david.GBFSCron.model.SystemInformation;
import com.david.GBFSCron.utils.JSONParser;
import org.json.JSONObject;

import java.util.List;

public class SystemInformationJSON {
    public String stationId;
    public String externalId;
    public String name;
    public String shortName;
    public String lat;
    public String lon;
    public List<String> rentalMethods;
    public Integer capacity;
    public Boolean eightdHasKeyDispenser;
    public Boolean hasKiosk;

    public JSONObject toJSON(){
        return JSONParser.toJSON(this.getClass(), this);
    }

    public SystemInformation toModel(){
        SystemInformation systemInformation = new SystemInformation();
        systemInformation.setStationId(stationId);
        systemInformation.setExternalId(externalId);
        systemInformation.setName(name);
        systemInformation.setShortName(shortName);
        systemInformation.setLat(lat);
        systemInformation.setLon(lon);
        systemInformation.setRentalMethods(rentalMethods);
        systemInformation.setCapacity(capacity);
        systemInformation.setEightdHasKeyDispenser(eightdHasKeyDispenser);
        systemInformation.setHasKiosk(hasKiosk);

        return systemInformation;
    }
}
