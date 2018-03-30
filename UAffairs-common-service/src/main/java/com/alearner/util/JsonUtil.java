package com.alearner.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {



    public static Object toModel(String jsonStr,Object cls){
        //    // 反序列化
        ObjectMapper objectMapper = new ObjectMapper();
        Object result = null;
        try {
            result = objectMapper.readValue(jsonStr,cls.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String toJsonStr(Object obj){

        // 序列化
        String strObj=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            strObj = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return strObj;
    }

}
