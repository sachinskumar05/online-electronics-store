package com.sk.estore.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    private JsonUtils(){throw new UnsupportedOperationException();}

    public static final Gson GSON = new GsonBuilder().create();

}
