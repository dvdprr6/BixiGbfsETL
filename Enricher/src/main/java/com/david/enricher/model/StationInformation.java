package com.david.enricher.model;

import org.json.JSONObject;

import java.util.List;

public class StationInformation {
    private String stationId;
    private String externalId;
    private String name;
    private String shortName;
    private String lat;
    private String lon;
    private List<String> rentalMethods;
    private Integer capacity;
    private Boolean eightdHasKeyDispenser;
    private Boolean hasKiosk;
    private JSONObject googleApiGeocodingJson;

    public StationInformation(){

    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public List<String> getRentalMethods() {
        return rentalMethods;
    }

    public void setRentalMethods(List<String> rentalMethods) {
        this.rentalMethods = rentalMethods;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getEightdHasKeyDispenser() {
        return eightdHasKeyDispenser;
    }

    public void setEightdHasKeyDispenser(Boolean eightdHasKeyDispenser) {
        this.eightdHasKeyDispenser = eightdHasKeyDispenser;
    }

    public Boolean getHasKiosk() {
        return hasKiosk;
    }

    public void setHasKiosk(Boolean hasKiosk) {
        this.hasKiosk = hasKiosk;
    }

    public JSONObject getGoogleApiGeocodingJson() {
        return googleApiGeocodingJson;
    }

    public void setGoogleApiGeocodingJson(JSONObject googleApiGeocodingJson) {
        this.googleApiGeocodingJson = googleApiGeocodingJson;
    }
}
