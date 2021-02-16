package de.leuphana.shop.customermicroservice.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.leuphana.shop.customermicroservice.component.behaviour.CustomerService;
import de.leuphana.shop.customermicroservice.component.behaviour.CustomerServiceImplementation;

public class CustomerServiceTest {
    private static CustomerService customerService;

    @BeforeAll
    public static void setupBeforeClass() {
        customerService = new CustomerServiceImplementation();
    }

    @Test
    public void canCustomerBeCreated() {
        Assertions.assertNotNull(customerService.createCustomer("Billy", "Bob", "Baumweg", "2a", "666", "Nussloch"));
    }
}
