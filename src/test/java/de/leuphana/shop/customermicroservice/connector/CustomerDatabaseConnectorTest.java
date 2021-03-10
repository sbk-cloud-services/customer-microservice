package de.leuphana.shop.customermicroservice.connector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.component.structure.PostAddress;

public class CustomerDatabaseConnectorTest {
    private static ApplicationContext applicationContext;
    private static CustomerDatabaseConnector customerDatabaseConnector;
    private static Customer customer;

    @BeforeAll
    public static void setupBeforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        
        customer = new Customer();
        customer.setFirstname("Billy");
        customer.setLastname("Bob");

        PostAddress postAddress = new PostAddress();
        postAddress.setStreet("Baumweg");
        postAddress.setHousenumber("2a");
        postAddress.setZipcode("666");
        postAddress.setCity("Nussloch");

        customer.setPostAddress(postAddress);

        customerDatabaseConnector = (CustomerDatabaseConnector) applicationContext.getBean("customerDatabaseConnector");
    }

    @Test
    public void canCustomerBeCreated() {
        customerDatabaseConnector.createCustomer(customer);
    }

    @Test
    public void canCustomerBeFetched() {
        Assertions.assertNull(customerDatabaseConnector.getCustomer(-1));
        Assertions.assertNotNull(customerDatabaseConnector.getCustomer(1));
    }
}
