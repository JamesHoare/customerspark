package com.netaporter.customerspark.services;

import com.netaporter.customerspark.domain.Customer;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toList;

/**
 * Created by jameshoare on 22/07/2014.
 */
public class CustomerService {


    private Map<String, Customer> customers = new ConcurrentHashMap<String, Customer>();

    public List<Customer> getCustomers() {
        return customers.values().stream().collect(toList());
    }

    public Customer getCustomer(String id) {
        return Optional.ofNullable(customers.get(id)).orElseThrow(() -> new NoSuchElementException("Customer could not be updated for id: " + id));
    }

    public Customer createCustomer(String name,String email) {
        Customer customer = new Customer(name, email);
        customers.put(customer.getId(), customer);
        return customer;
    }

    public Customer updateCustomer(String id, String name, String email) {
        Optional<Customer> customer = Optional.ofNullable(customers.get(id));
        customer.ifPresent(c -> c.setName(name));
        customer.ifPresent(c -> c.setEmail(email));
        return customer.orElseThrow(() -> new NoSuchElementException("Customer could not be updated for id: " + id));
    }


}
