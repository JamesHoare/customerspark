package com.netaporter.customerspark;

import com.netaporter.customerspark.controller.CustomerController;
import com.netaporter.customerspark.services.CustomerService;


/**
 * Created by jameshoare on 21/07/2014.
 */
public class Main {

    public static void main(String[] args) {

        new CustomerController(new CustomerService());

    }
}
