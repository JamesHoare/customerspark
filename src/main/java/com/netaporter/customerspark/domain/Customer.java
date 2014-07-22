package com.netaporter.customerspark.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by jameshoare on 22/07/2014.
 */
public class Customer {



    private String id;

    @NotNull
    private String name;
    @Email
    private String email;

    public Customer(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
