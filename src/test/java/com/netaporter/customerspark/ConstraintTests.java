package com.netaporter.customerspark;

import com.netaporter.customerspark.domain.Customer;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by jameshoare on 29/07/2014.
 */
public class ConstraintTests {


    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void customerNameIsEmpty() {
        Customer customer = new Customer("", "james.hoare@net-a-porter.com" );

        Set<ConstraintViolation<Customer>> constraintViolations =
                validator.validate( customer );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "may not be empty",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void customerEmailIsEmpty() {
        Customer customer = new Customer("James Hoare", null );

        Set<ConstraintViolation<Customer>> constraintViolations =
                validator.validate( customer );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "may not be empty",
                constraintViolations.iterator().next().getMessage()
        );
    }

}
