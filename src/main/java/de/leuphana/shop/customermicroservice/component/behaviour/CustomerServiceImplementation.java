package de.leuphana.shop.customermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.component.structure.PostAddress;
import de.leuphana.shop.customermicroservice.connector.CustomerDatabaseConnector;

public class CustomerServiceImplementation implements CustomerService {

    private static CustomerService customerServiceImplementation;
    private CustomerDatabaseConnector customerDatabaseConnector;

    public static CustomerService getInstance() {
        if(customerServiceImplementation == null) customerServiceImplementation = new CustomerServiceImplementation();
        return customerServiceImplementation;
    }

    public void setCustomerDatabaseConnector(CustomerDatabaseConnector customerDatabaseConnector) {
        this.customerDatabaseConnector = customerDatabaseConnector;
    }

    @Override
    public Customer createCustomer(String firstname, String lastname, String street, String housenumber, String zipcode, String city) {
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        
        PostAddress postAddress = new PostAddress();
        postAddress.setStreet(street);
        postAddress.setHousenumber(housenumber);
        postAddress.setZipcode(zipcode);
        postAddress.setCity(city);

        customer.setPostAddress(postAddress);

        customer.setId(customerDatabaseConnector.createCustomer(customer));

        return customer;
    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerDatabaseConnector.getCustomer(id);
    }
}