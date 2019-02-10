package com.david.enricher.dao.stationinformation;

public class StationInformationFactory {
    public static StationInformationDao getStationInformationDao(){
        return new StationInformationDaoImpl();
    }
}
