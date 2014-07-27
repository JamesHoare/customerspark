package com.netaporter.customerspark.controller;


import com.netaporter.customerspark.services.CustomerService;
import com.netaporter.customerspark.transformers.JsonTransformer;

import static spark.Spark.get;

/**
 * Created by jameshoare on 21/07/2014.
 */
public class CustomerController {

    public CustomerController(final CustomerService customerService) {

        get("/customer/:id", "application/json", (req, res) -> {
            String id = req.params(":id");
            return customerService.getUser(id);
        }, new JsonTransformer());


    }


}










