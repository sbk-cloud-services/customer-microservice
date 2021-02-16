package de.leuphana.shop.customermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.component.structure.CustomerImplementation;
import de.leuphana.shop.customermicroservice.component.structure.PostAddress;
import de.leuphana.shop.customermicroservice.component.structure.PostAddressImplementation;

public class CustomerServiceImplementation implements CustomerService {

    @Override
    public Customer createCustomer(String firstname, String lastname, String street, String housenumber, String zipcode, String city) {
        Customer customer = new CustomerImplementation();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        
        PostAddress postAddress = new PostAddressImplementation();
        postAddress.setStreet(street);
        postAddress.setHousenumber(housenumber);
        postAddress.setZipcode(zipcode);
        postAddress.setCity(city);

        customer.setPostAddress(postAddress);

        return customer;
    }
}