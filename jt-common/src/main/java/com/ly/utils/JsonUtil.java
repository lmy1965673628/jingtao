package com.ly.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

/**
 * json转化工具
 */
@Configuration
public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 根据API将对象转化为JSON.同时将JSON转化为对象.
     *
     * @param obj 转化的对象
     * @return 转化后的json串
     */
    public static String toJSON(Object obj) {
        String result = null;
        try {
            result = MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    /**
     * json转化为对象
     *
     * @param json        json串
     * @param targetClass 要转化的实体class
     * @param <T>         转化后的实体对象
     * @return
     */
    public static <T> T toObject(String json, Class<T> targetClass) {
        T obj = null;
        try {
            obj = MAPPER.readValue(json, targetClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return obj;
    }
}
