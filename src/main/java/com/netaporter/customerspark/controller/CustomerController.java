package com.netaporter.customerspark.controller;


import com.netaporter.customerspark.services.CustomerService;
import com.netaporter.customerspark.transformers.JsonTransformer;

import static spark.Spark.*;

/**
 * Created by jameshoare on 21/07/2014.
 */
public class CustomerController {

    public CustomerController(final CustomerService customerService) {


        get("/customer/:id", (req, res) -> {
            String id = req.params(":id");
            return customerService.getCustomer(id);
        }, new JsonTransformer());

        /**
         * e.g  curl -XPOST http://localhost:4567/customer?name=James&email=james.hoare@net-a-porter.com
         */
        post("/customer", (req, res) -> customerService.createCustomer(
                req.queryParams("name"),
                req.queryParams("email")
        ), new JsonTransformer());

        put("/customer/:id", (req, res) -> customerService.updateCustomer(
                req.params(":id"),
                req.queryParams("name"),
                req.queryParams("email")
        ), new JsonTransformer());


    }


}










