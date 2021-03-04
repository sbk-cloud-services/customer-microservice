package de.leuphana.shop.customermicroservice.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.leuphana.shop.customermicroservice.component.behaviour.CustomerService;
import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.component.structure.PostAddress;

@RestController
public class CustomerRestController {

    @PostMapping("/customers")
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer) {
        CustomerService customerService = (CustomerService) CustomerServiceApplication.getApplicationContext().getBean("customerService");
        PostAddress postAddress = customer.getPostAddress();
        
        return customerService.createCustomer(customer.getFirstname(), customer.getLastname(), postAddress.getStreet(), postAddress.getHousenumber(), postAddress.getZipcode(), postAddress.getCity());
    }

    @GetMapping("/customers/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") Integer id) {
        CustomerService customerService = (CustomerService) CustomerServiceApplication.getApplicationContext().getBean("customerService");

        return customerService.getCustomer(id);
    }
}
