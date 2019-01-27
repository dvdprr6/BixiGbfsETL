package com.david.GBFSCron.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;

public class JSONParser {

    public static <T> JSONObject toJSON(Class<T> clazz, Object object){
        Gson gson = new GsonBuilder().create();
        return new JSONObject(gson.toJson((T) object));
    }

    public static <T> T parseJSON(String json, Class<T> clazz) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().create();

        return gson.fromJson(jsonObject, clazz);
    }
}
