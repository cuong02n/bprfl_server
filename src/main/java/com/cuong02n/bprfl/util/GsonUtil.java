package com.cuong02n.bprfl.util;

import com.google.gson.Gson;


public class GsonUtil {
    private static final Gson gson = new Gson();

    public static <T> T fromJson(String in, Class<T> classOfT) {
        return gson.fromJson(in, classOfT);
    }

}
