package com.david.enricher.dao.stationinformation;

import com.david.avro.StationInformation;
import com.david.enricher.connection.HBaseConnection;
import com.david.enricher.utils.Constants;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public class StationInformationDaoImpl implements StationInformationDao {
    private Table table;

    StationInformationDaoImpl(){
        try{
            this.table = HBaseConnection.getHBaseConnection().getTable(TableName.valueOf(Constants.HBASE_BIXI_GBFS_TABLE));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public StationInformation getById(String id) {
        Result result = null;

        Get get = new Get(Bytes.toBytes(id));

        try{
            result = table.get(get);
        }catch(IOException e){
            e.printStackTrace();
        }


        return null;
    }
}
