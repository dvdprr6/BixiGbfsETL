/*
        GGGGGGGGGGGGGBBBBBBBBBBBBBBBBB      SSSSSSSSSSSSSSS         CCCCCCCCCCCCC
     GGG::::::::::::GB::::::::::::::::B   SS:::::::::::::::S     CCC::::::::::::C
   GG:::::::::::::::GB::::::BBBBBB:::::B S:::::SSSSSS::::::S   CC:::::::::::::::C
  G:::::GGGGGGGG::::GBB:::::B     B:::::BS:::::S     SSSSSSS  C:::::CCCCCCCC::::C
 G:::::G       GGGGGG  B::::B     B:::::BS:::::S             C:::::C       CCCCCCrrrrr   rrrrrrrrr      ooooooooooo   nnnn  nnnnnnnn
G:::::G                B::::B     B:::::BS:::::S            C:::::C              r::::rrr:::::::::r   oo:::::::::::oo n:::nn::::::::nn
G:::::G                B::::BBBBBB:::::B  S::::SSSS         C:::::C              r:::::::::::::::::r o:::::::::::::::on::::::::::::::nn
G:::::G    GGGGGGGGGG  B:::::::::::::BB    SS::::::SSSSS    C:::::C              rr::::::rrrrr::::::ro:::::ooooo:::::onn:::::::::::::::n
G:::::G    G::::::::G  B::::BBBBBB:::::B     SSS::::::::SS  C:::::C               r:::::r     r:::::ro::::o     o::::o  n:::::nnnn:::::n
G:::::G    GGGGG::::G  B::::B     B:::::B       SSSSSS::::S C:::::C               r:::::r     rrrrrrro::::o     o::::o  n::::n    n::::n
G:::::G        G::::G  B::::B     B:::::B            S:::::SC:::::C               r:::::r            o::::o     o::::o  n::::n    n::::n
 G:::::G       G::::G  B::::B     B:::::B            S:::::S C:::::C       CCCCCC r:::::r            o::::o     o::::o  n::::n    n::::n
  G:::::GGGGGGGG::::GBB:::::BBBBBB::::::BSSSSSSS     S:::::S  C:::::CCCCCCCC::::C r:::::r            o:::::ooooo:::::o  n::::n    n::::n
   GG:::::::::::::::GB:::::::::::::::::B S::::::SSSSSS:::::S   CC:::::::::::::::C r:::::r            o:::::::::::::::o  n::::n    n::::n
     GGG::::::GGG:::GB::::::::::::::::B  S:::::::::::::::SS      CCC::::::::::::C r:::::r             oo:::::::::::oo   n::::n    n::::n
        GGGGGG   GGGGBBBBBBBBBBBBBBBBB    SSSSSSSSSSSSSSS           CCCCCCCCCCCCC rrrrrrr               ooooooooooo     nnnnnn    nnnnnn
*/
package com.david.GBFSCron.main;

import com.david.GBFSCron.dao.stationinformation.StationInformationFactory;
import com.david.GBFSCron.json.StationInformationJSON;
import com.david.GBFSCron.model.StationInformation;
import com.david.GBFSCron.utils.Constants;
import com.david.GBFSCron.utils.JSONParser;
import com.david.GBFSCron.utils.httpclient.BasicNameValuePair;
import com.david.GBFSCron.utils.httpclient.HttpConnectionUtilFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<StationInformation> stationInformationList = new ArrayList<StationInformation>();
        List<BasicNameValuePair> queryParams = new ArrayList<BasicNameValuePair>();

        String stationInformationJSONResponse = HttpConnectionUtilFactory.getHttpConnection().sendHttpGet(Constants.SYSTEM_INFORMATION_JSON);

        JSONObject jsonObject = new JSONObject(stationInformationJSONResponse);
        JSONArray stationInformationJSONArray = jsonObject.getJSONObject("data").getJSONArray("stations");
        long lastUpdated = jsonObject.getLong("last_updated");

        for(int i = 0; i < stationInformationJSONArray.length(); i++){
            JSONObject json = stationInformationJSONArray.getJSONObject(i);
            StationInformationJSON stationInformationJSON = JSONParser.parseJSON(json.toString(), StationInformationJSON.class);
            StationInformation stationInformation = stationInformationJSON.toModel();
            queryParams.add(new BasicNameValuePair("latlng", stationInformation.getLat() + "," + stationInformation.getLon()));
            queryParams.add(new BasicNameValuePair("key", Constants.API_KEY));
            String googleApiResponse = HttpConnectionUtilFactory.getHttpConnection().sendHttpGet(Constants.GOOGLE_API_URL, queryParams);
            stationInformation.setGoogleApiGeocodingJson(new JSONObject(googleApiResponse));
            stationInformationList.add(stationInformation);
            queryParams.clear();
        }

        StationInformationFactory.getSystemInformationDao().insert(stationInformationList, lastUpdated);

        stationInformationList.clear();

    }
}
