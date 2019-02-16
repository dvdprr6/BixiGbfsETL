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
    public StationInformation getById(int id) {
        Result result = null;

        Get get = new Get(Bytes.toBytes(id));

        try{
            result = table.get(get);
        }catch(IOException e){
            e.printStackTrace();
        }


        return getStationsInformation(result);
    }

    private StationInformation getStationsInformation(Result result){
        String stationId;
        String externalId;
        String name;
        String shortName;
        String lat;
        String lon;
        List<String> rentalMethods = new ArrayList<String>();
        Integer capacity;
        Boolean eightdHasKeyDispenser;
        Boolean hasKiosk;
        String googleApiGeocodingJson;

        try{
            stationId = new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_STATION_ID)));
        }catch(Exception e){
            stationId = "";
        }

        try{
            externalId = new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_EXTERNAL_ID)));
        }catch(Exception e){
            externalId = "";
        }

        try{
            name = new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_NAME)));
        }catch(Exception e){
            name = "";
        }

        try{
            shortName = new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_SHORT_NAME)));
        }catch(Exception e){
            shortName = "";
        }

        try{
            lat = new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_LAT)));
        }catch(Exception e){
            lat = "";
        }

        try{
            lon = new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_LON)));
        }catch(Exception e){
            lon = "";
        }

        try{
            rentalMethods.add(new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_RENTAL_METHODS_0))));
        }catch(Exception e){
            rentalMethods.clear();
        }

        try{
            rentalMethods.add(new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_RENTAL_METHODS_1))));
        }catch(Exception e){
            rentalMethods.clear();
        }

        try{
            capacity = Integer.valueOf(new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_CAPACITY))));
        }catch(Exception e){
            capacity = null;
        }

        try{
            eightdHasKeyDispenser = Boolean.valueOf(new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_EIGHTD_HAS_KEY_DISPENCER))));
        }catch(Exception e){
            eightdHasKeyDispenser = null;
        }

        try{
            hasKiosk = Boolean.valueOf(new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_STATION_INFORMATION),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_HAS_KIOSK))));
        }catch(Exception e){
            hasKiosk = null;
        }

        try{
            googleApiGeocodingJson = new String(result.getValue(
                    Bytes.toBytes(Constants.HBASE_COLUMN_FAMILY_GOOGLE_GEOCODING),
                    Bytes.toBytes(Constants.HBASE_STATION_INFORMATION_QUALIFIER_GOOGLE_GEOCODING)));
        }catch(Exception e){
            googleApiGeocodingJson = "";
        }

        return new StationInformation(
                stationId,
                externalId,
                name,
                shortName,
                lat,
                lon,
                rentalMethods,
                capacity,
                eightdHasKeyDispenser,
                hasKiosk,
                googleApiGeocodingJson);
    }
}
