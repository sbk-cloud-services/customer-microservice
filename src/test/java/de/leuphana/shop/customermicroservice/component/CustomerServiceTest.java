package de.leuphana.shop.customermicroservice.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.customermicroservice.component.behaviour.CustomerService;
import de.leuphana.shop.customermicroservice.component.behaviour.CustomerServiceImplementation;
import de.leuphana.shop.customermicroservice.connector.CustomerDatabaseConnector;

public class CustomerServiceTest {
    private static CustomerService customerService;

    @BeforeAll
    public static void setupBeforeClass() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext-jpa-connector.xml");
        CustomerDatabaseConnector customerDatabaseConnector = (CustomerDatabaseConnector) applicationContext.getBean("customerDatabaseConnector");

        customerService = CustomerServiceImplementation.getInstance();
        customerService.setCustomerDatabaseConnector(customerDatabaseConnector);
    }

    @Test
    public void canCustomerBeCreated() {
        Assertions.assertNotNull(customerService.createCustomer("Billy", "Bob", "Baumweg", "2a", "666", "Nussloch"));
    }
}
