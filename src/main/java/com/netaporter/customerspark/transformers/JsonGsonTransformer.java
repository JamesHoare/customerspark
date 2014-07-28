package com.netaporter.customerspark.transformers;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by jameshoare on 28/07/2014.
 */
public class JsonGsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}
