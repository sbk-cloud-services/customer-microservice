package de.leuphana.shop.customermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.connector.CustomerDatabaseConnector;

public interface CustomerService {
    public Customer createCustomer(String firstname, String lastname, String street, String housenumber, String zipcode, String city);
    public Customer getCustomer(Integer id);
    public void setCustomerDatabaseConnector(CustomerDatabaseConnector customerDatabaseConnector);
}