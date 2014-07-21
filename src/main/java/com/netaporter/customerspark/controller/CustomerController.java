package com.netaporter.customerspark.controller;


import com.netaporter.customerspark.transformers.JsonTransformer;

import static spark.Spark.get;

/**
 * Created by jameshoare on 21/07/2014.
 */
public class CustomerController {

    public CustomerController() {

        get("/customer/:id", "application/json", (req, res) -> {
            String id = req.params(":id");
            return new Customer("james", "Hoare");
        }, new JsonTransformer());


    }

    private static class Customer {

        private String firstName;
        private String lastName;

        private Customer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }


}










