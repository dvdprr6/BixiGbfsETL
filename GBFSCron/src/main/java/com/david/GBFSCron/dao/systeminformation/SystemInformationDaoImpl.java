package com.david.GBFSCron.dao.systeminformation;

import com.david.GBFSCron.connection.HBaseConnection;
import com.david.GBFSCron.model.SystemInformation;
import com.david.GBFSCron.utils.Constants;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;
import java.util.List;

public class SystemInformationDaoImpl implements SystemInformationDao {
    private Table table;

    SystemInformationDaoImpl(){
        try{
            this.table = HBaseConnection.getHBaseConnection().getTable(TableName.valueOf(Constants.HBASE_SYSTEM_INFORMATION_TABLE));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(List<SystemInformation> systemInformation) {

    }
}
