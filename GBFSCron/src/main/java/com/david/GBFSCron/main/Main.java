package com.david.GBFSCron.main;

import com.david.GBFSCron.dao.stationinformation.StationInformationFactory;
import com.david.GBFSCron.json.StationInformationJSON;
import com.david.GBFSCron.model.StationInformation;
import com.david.GBFSCron.utils.Constants;
import com.david.GBFSCron.utils.JSONParser;
import com.david.GBFSCron.utils.httpclient.HttpConnectionUtilFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        List<StationInformation> stationInformationList = new ArrayList<StationInformation>();
        //sleep5Seconds();

        String stationInformationJSONResponse = HttpConnectionUtilFactory.getHttpConnection().sendHttpGet(Constants.SYSTEM_INFORMATION_JSON);

        JSONObject jsonObject = new JSONObject(stationInformationJSONResponse);
        JSONArray stationInformationJSONArray = jsonObject.getJSONObject("data").getJSONArray("stations");
        long lastUpdated = jsonObject.getLong("last_updated");

        for(int i = 0; i < stationInformationJSONArray.length(); i++){
            JSONObject json = stationInformationJSONArray.getJSONObject(i);
            StationInformationJSON stationInformationJSON = JSONParser.parseJSON(json.toString(), StationInformationJSON.class);
            StationInformation stationInformation = stationInformationJSON.toModel();
            stationInformationList.add(stationInformation);
        }

        StationInformationFactory.getSystemInformationDao().insert(stationInformationList, lastUpdated);

    }

    private static void sleep5Seconds(){
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
