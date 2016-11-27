package com.example.qwerty.gsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import static java.lang.Boolean.FALSE;

/**
 * Created by qwerty on 24.11.16.
 */

public class JsonParser {
    private final static Gson gson;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(boolean.class, new JsonCommunityDeserializer())
                .registerTypeAdapter(User.Gender.class, new JsonGenderDeserializer())
                .create();
    }

    JsonCommunity parse(final String json) {
        return gson.fromJson(json, JsonCommunity.class);
    }

    private static class JsonCommunityDeserializer implements JsonDeserializer<Boolean> {
        @Override
        public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonPrimitive jsonObject = json.getAsJsonPrimitive();
            String str = jsonObject.getAsString().toLowerCase();
            if (str.contains("yes") || str.contains("1") || str.contains("true")) { return Boolean.TRUE; }
            return FALSE;
        }
    }

 private static class JsonGenderDeserializer implements JsonDeserializer<User.Gender> {
     @Override
     public User.Gender deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
         JsonPrimitive jsonObject = json.getAsJsonPrimitive();
         if (jsonObject.getAsString().equals("FEMALE")) { return User.Gender.FEMALE; }
         if (jsonObject.getAsString().equals("MALE")) { return User.Gender.MALE; }
         return User.Gender.NOT_SURE;
     }
 }
}
