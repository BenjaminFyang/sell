package com.imooc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author 方洋
 * @date 2018/2/7 18:48
 */
public class JsonUtil {

    /**
     * 将对象格式化的工具
     *
     * @param object 表示的对象
     * @return 对象的jsonp的格式话
     */
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
