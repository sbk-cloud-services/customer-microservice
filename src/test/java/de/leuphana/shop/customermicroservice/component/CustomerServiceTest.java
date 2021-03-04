package de.leuphana.shop.customermicroservice.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.customermicroservice.component.behaviour.CustomerService;

public class CustomerServiceTest {
    private static CustomerService customerService;

    @BeforeAll
    public static void setupBeforeClass() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        customerService = (CustomerService) applicationContext.getBean("customerService");
    }

    @Test
    public void canCustomerBeCreated() {
        Assertions.assertNotNull(customerService.createCustomer("Billy", "Bob", "Baumweg", "2a", "666", "Nussloch"));
    }

    @Test
    public void canCustomerBeFetched() {
        Assertions.assertNotNull(customerService.getCustomer(1));
    }
}
