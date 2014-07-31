package com.netaporter.customerspark.controller;


import com.netaporter.customerspark.services.CustomerService;
import com.netaporter.customerspark.transformers.JsonTransformer;

import static spark.Spark.*;

/**
 * Created by jameshoare on 21/07/2014.
 */
public class CustomerController {

    public CustomerController(final CustomerService customerService, JsonTransformer jsonTransformer) {


        get("/customer/:id", (req, res) -> {
            String id = req.params(":id");
            return customerService.getCustomer(id);
        }, jsonTransformer);

        get("/customers/", (req, res) -> {
            return customerService.getCustomers();
        }, jsonTransformer);


        /**
         * e.g  curl -XPOST http://localhost:4567/customer?name=James&email=james.hoare@net-a-porter.com
         */
        post("/customer", (req, res) -> {
            res.status(201);
            return customerService.createCustomer(req.queryParams("name"), req.queryParams("email"));
        }, jsonTransformer);

        put("/customer/:id", (req, res) -> customerService.updateCustomer(
                req.params(":id"),
                req.queryParams("name"),
                req.queryParams("email")
        ), jsonTransformer);


    }


}










