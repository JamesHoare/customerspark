package com.netaporter.customerspark.transformers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import spark.ResponseTransformer;

import java.nio.charset.Charset;

/**
 * Created by jameshoare on 21/07/2014.
 */
public class JsonTransformer implements ResponseTransformer {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private static ObjectMapper mapper = new ObjectMapper().
            configure(SerializationFeature.INDENT_OUTPUT, true).
            registerModule(new JSR310Module());


    @Override
    public String render(Object model) {
        try {
            return mapper.writeValueAsString(model);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot serialize model to JSON", ex);
        }

    }

}
