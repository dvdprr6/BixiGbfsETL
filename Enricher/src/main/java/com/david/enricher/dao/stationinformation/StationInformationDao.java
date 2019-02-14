package com.david.enricher.dao.stationinformation;

import com.david.avro.StationInformation;

import java.util.List;

public interface StationInformationDao {
    public StationInformation getById(String id);
}
