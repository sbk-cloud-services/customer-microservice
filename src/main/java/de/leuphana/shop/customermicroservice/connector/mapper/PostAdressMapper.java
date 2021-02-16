package de.leuphana.shop.customermicroservice.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.customermicroservice.component.structure.PostAddressImplementation;
import de.leuphana.shop.customermicroservice.connector.entity.PostAddressEntityImplementation;


public class PostAdressMapper {
    private static Mapper mapper;

    static {
        mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    public static PostAddressEntityImplementation mapCustomerToCustomerEntity(PostAddressImplementation postAddressImplementation) {
        return mapper.map(postAddressImplementation, PostAddressEntityImplementation.class);
    }

    public static PostAddressImplementation mapCustomerToCustomerEntity(PostAddressEntityImplementation postAddressEntityImplementation) {
        return mapper.map(postAddressEntityImplementation, PostAddressImplementation.class);
    }
}
