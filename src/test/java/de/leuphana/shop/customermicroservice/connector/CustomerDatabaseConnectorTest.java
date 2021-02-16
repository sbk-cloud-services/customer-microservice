package de.leuphana.shop.customermicroservice.connector;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.component.structure.CustomerImplementation;

public class CustomerDatabaseConnectorTest {
    private static ApplicationContext applicationContext;
    private static CustomerDatabaseConnector customerDatabaseConnector;
    private static Customer customer;

    @BeforeAll
    public static void setupBeforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("applicationcontext-jpa-connector.xml");
        
        customer = new CustomerImplementation();
        customer.setFirstname("Test");
        customer.setLastname("123");

        customerDatabaseConnector = (CustomerDatabaseConnector) applicationContext.getBean("customerDatabaseConnector");
    }

    @Test
    public void canCustomerBeCreated() {
        customerDatabaseConnector.createCustomer(customer);
    }
}
