package de.leuphana.shop.customermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;

public interface CustomerService {
    public Customer createCustomer(String firstname, String lastname, String street, String housenumber, String zipcode, String city);
    public Customer getCustomer(Integer id);
}