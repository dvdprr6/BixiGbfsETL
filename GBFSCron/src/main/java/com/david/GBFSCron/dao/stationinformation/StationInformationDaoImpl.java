package com.david.GBFSCron.dao.stationinformation;

import com.david.GBFSCron.connection.HBaseConnection;
import com.david.GBFSCron.model.StationInformation;
import com.david.GBFSCron.utils.Constants;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
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
    public void insert(List<StationInformation> stationInformationList, long lastUpdated) {
        List<Put> stationInformationPuts = new ArrayList<Put>();

        for(StationInformation stationInformation : stationInformationList){
            Put put = new Put(Bytes.toBytes(stationInformation.getStationId()), lastUpdated);

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_EXTERNAL_ID),
                    Bytes.toBytes(stationInformation.getExternalId())
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_NAME),
                    Bytes.toBytes(stationInformation.getName())
            );


            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_SHORT_NAME),
                    Bytes.toBytes(stationInformation.getShortName())
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_SHORT_NAME),
                    Bytes.toBytes(stationInformation.getShortName())
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_LAT),
                    Bytes.toBytes(stationInformation.getLat())
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_LON),
                    Bytes.toBytes(stationInformation.getLon())
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_RENTAL_METHODS_0),
                    Bytes.toBytes(stationInformation.getRentalMethods().get(0))
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_RENTAL_METHODS_1),
                    Bytes.toBytes(stationInformation.getRentalMethods().get(1))
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_CAPACITY),
                    Bytes.toBytes(stationInformation.getCapacity().toString())
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_EIGHTD_HAS_KEY_DISPENCER),
                    Bytes.toBytes(stationInformation.getEightdHasKeyDispenser().toString())
            );

            put.addColumn(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_HAS_KIOSK),
                    Bytes.toBytes(stationInformation.getHasKiosk().toString())
            );

            stationInformationPuts.add(put);
        }

        try{
            this.table.put(stationInformationPuts);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
