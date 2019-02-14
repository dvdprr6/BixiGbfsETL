package com.david.enricher.dao.stationinformation;

import com.david.avro.StationInformation;

public interface StationInformationDao {
    public StationInformation getById(String id);
}
