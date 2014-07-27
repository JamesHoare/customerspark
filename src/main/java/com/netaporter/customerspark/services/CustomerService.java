package com.netaporter.customerspark.services;

import com.netaporter.customerspark.domain.Customer;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toList;

/**
 * Created by jameshoare on 22/07/2014.
 */
public class CustomerService {


    private Map<String, Customer> customers = new ConcurrentHashMap<>();

    public List<Customer> getAllUsers() {
        return customers.values().stream().collect(toList());
    }

    public Customer getUser(String id) {
        return customers.get(id);
    }

    public Customer createUser(@NotBlank String name, @NotBlank String email) {
        Customer customer = new Customer(name, email);
        customers.put(customer.getId(), customer);
        return customer;
    }

    public Customer updateUser(String id, String name, String email) {
        Customer customer = Optional.ofNullable(getUser(id)));

        customer.setName(name);
        customer.setEmail(email);
        return customer;
    }


}
