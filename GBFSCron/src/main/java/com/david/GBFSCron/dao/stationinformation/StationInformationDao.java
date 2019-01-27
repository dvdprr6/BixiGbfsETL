package com.david.GBFSCron.dao.stationinformation;

import com.david.GBFSCron.model.StationInformation;

import java.util.List;

public interface StationInformationDao {
    public void insert(List<StationInformation> stationInformationList, long lastUpdated);
}
