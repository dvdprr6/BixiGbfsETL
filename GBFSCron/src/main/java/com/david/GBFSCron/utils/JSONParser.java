package com.david.GBFSCron.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

public class JSONParser {

    public static <T> JSONObject toJSON(Class<T> clazz, Object object){
        Gson gson = new GsonBuilder().create();
        return new JSONObject(gson.toJson((T) object));
    }
}
