package com.david.GBFSCron.dao.systeminformation;

import com.david.GBFSCron.model.SystemInformation;

public class SystemInformationFactory {
    public static SystemInformationDao getSystemInformationDao(){
        return new SystemInformationDaoImpl();
    }
}
