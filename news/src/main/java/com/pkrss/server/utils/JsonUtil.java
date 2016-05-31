package com.pkrss.server.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.pkrss.server.share.SharedConstants;

public class JsonUtil {

    /**	
     * <p>Description: 用Jackson库，适合大数据，小数据性能不如Gson             </p>
     * <p>Create Time: 2016年2月25日   </p>
     * @author lijianqiang
     * @param object
     * @return json
     */
    public static String toJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "json error, please contact server admin";
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static <T> T fromJson(String content, Class<T> valueType) throws JsonParseException, JsonMappingException,
            IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, valueType);
    }

    public static <T> T fromJson(String content, TypeReference<T> valueTypeRef) throws JsonParseException,
            JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, valueTypeRef);
    }
    
    /**	
     * <p>Description: 用Gson库，对Date按格式转String             </p>
     * <p>Create Time: 2016年2月25日   </p>
     * @author lijianqiang
     * @param object
     * @return
     */
    public static String toGson(Object object) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat(SharedConstants.Format.GSON_DATE_FORMAT).create();
        return gson.toJson(object);
    }

    public static <T> T fromGson(String json, Class<T> classOfT) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat(SharedConstants.Format.GSON_DATE_FORMAT).create();
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromGson(String json, Type typeOfT) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat(SharedConstants.Format.GSON_DATE_FORMAT).create();
        return gson.fromJson(json, typeOfT);
    }
    
    public static String toGsonDate2Long(Object object) {
        Gson gson = create();
        return gson.toJson(object);
    }

    public static <T> T fromGsonLong2Date(String json, Class<T> classOfT) {
        Gson gson = create();
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromGsonLong2Date(String json, Type typeOfT) {
        Gson gson = create();
        return gson.fromJson(json, typeOfT);
    }
    
    //
    public static Gson create() {
        GsonBuilder gb = new GsonBuilder().serializeNulls();
        gb.registerTypeAdapter(Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG);
        gb.registerTypeAdapter(Date.class, new DateDeserializer()).setDateFormat(DateFormat.LONG);
        Gson gson = gb.create();
        return gson;
    }
    
    public static class DateDeserializer implements JsonDeserializer<Date> {
        
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            return new Date(json.getAsJsonPrimitive().getAsLong());
        }
    }
    
    public static class DateSerializer implements JsonSerializer<Date> {
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getTime());
        }
    }

}
