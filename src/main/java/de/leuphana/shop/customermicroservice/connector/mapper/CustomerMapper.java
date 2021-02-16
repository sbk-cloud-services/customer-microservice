package de.leuphana.shop.customermicroservice.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.customermicroservice.component.structure.CustomerImplementation;
import de.leuphana.shop.customermicroservice.connector.entity.CustomerEntityImplementation;


public class CustomerMapper {
    private static Mapper mapper;

    static {
        mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    public static CustomerEntityImplementation mapCustomerToCustomerEntity(CustomerImplementation customerImplementation) {
        return mapper.map(customerImplementation, CustomerEntityImplementation.class);
    }

    public static CustomerImplementation mapCustomerToCustomerEntity(CustomerEntityImplementation customerEntityImplementation) {
        return mapper.map(customerEntityImplementation, CustomerImplementation.class);
    }
}
