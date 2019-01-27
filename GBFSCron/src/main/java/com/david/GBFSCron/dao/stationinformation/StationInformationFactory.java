package com.david.GBFSCron.dao.stationinformation;

public class StationInformationFactory {
    public static StationInformationDao getSystemInformationDao(){
        return new StationInformationDaoImpl();
    }
}
