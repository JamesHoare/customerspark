package com.netaporter.customerspark.transformers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import spark.ResponseTransformer;

/**
 * Created by jameshoare on 21/07/2014.
 */
public class JsonTransformer implements ResponseTransformer {

    private ObjectMapper mapper = new ObjectMapper().registerModule(new AfterburnerModule());

    @Override
    public String render(Object model)  {
        try {
            return mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
