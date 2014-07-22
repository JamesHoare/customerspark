package com.netaporter.customerspark.services;

import com.netaporter.customerspark.domain.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by jameshoare on 22/07/2014.
 */
public class CustomerService {


    private Map<String, Customer> customers = new HashMap<>();

    public List<Customer> getAllUsers() {
        return customers.values().stream().collect(toList());
    }

    public Customer getUser(String id) {
        return customers.get(id);
    }

    public Customer createUser(String name, String email) {
        //todo handle constraint violation
        Customer customer = new Customer(name, email);
        customers.put(customer.getId(), customer);
        return customer;
    }

    public Customer updateUser(String id, String name, String email) {
        Customer customer = customers.get(id);
        //todo Optional check
        customer.setName(name);
        customer.setEmail(email);
        return customer;
    }




}
