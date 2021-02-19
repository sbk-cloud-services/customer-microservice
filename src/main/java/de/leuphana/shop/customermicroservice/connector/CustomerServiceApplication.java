package de.leuphana.shop.customermicroservice.connector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.customermicroservice.component.behaviour.CustomerServiceImplementation;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext-jpa-connector.xml");
        CustomerDatabaseConnector customerDatabaseConnector = (CustomerDatabaseConnector) applicationContext.getBean("customerDatabaseConnector");
        CustomerServiceImplementation.getInstance().setCustomerDatabaseConnector(customerDatabaseConnector);
    }
}
