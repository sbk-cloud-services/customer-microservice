package de.leuphana.shop.customermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.component.structure.PostAddress;

public class CustomerServiceImplementation implements CustomerService {

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

        return customer;
    }
}