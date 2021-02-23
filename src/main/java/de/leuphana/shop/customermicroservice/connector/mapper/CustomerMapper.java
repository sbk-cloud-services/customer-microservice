package de.leuphana.shop.customermicroservice.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.connector.entity.CustomerEntity;


public class CustomerMapper {
    private static Mapper mapper;

    static {
        mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    public static CustomerEntity mapCustomerToCustomerEntity(Customer customer) {
        return mapper.map(customer, CustomerEntity.class);
    }

    public static Customer mapCustomerEntityToCustomer(CustomerEntity customerEntity) {
        return mapper.map(customerEntity, Customer.class);
    }
}
