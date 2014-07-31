package com.netaporter.customerspark;

import com.netaporter.customerspark.controller.CustomerController;
import com.netaporter.customerspark.services.CustomerService;
import com.netaporter.customerspark.transformers.JsonTransformer;


/**
 * Created by jameshoare on 21/07/2014.
 */
public class Main {

    /**
     * Wire the Application
     *
     * @param args
     */
    public static void main(String[] args) {

        new CustomerController(new CustomerService(), new JsonTransformer());

    }
}
