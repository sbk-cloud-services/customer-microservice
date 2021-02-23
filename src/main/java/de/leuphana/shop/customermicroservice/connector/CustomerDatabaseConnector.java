package de.leuphana.shop.customermicroservice.connector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.transaction.annotation.Transactional;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.customermicroservice.connector.entity.CustomerEntity;
import de.leuphana.shop.customermicroservice.connector.mapper.CustomerMapper;

public class CustomerDatabaseConnector {
    private EntityManager entityManager;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Integer createCustomer(Customer customer) {
        CustomerEntity customerEntity = CustomerMapper.mapCustomerToCustomerEntity(customer);
        entityManager.persist(customerEntity);
        return customerEntity.getId();
    }

    @Transactional
    public Customer getCustomer(Integer id) {
        CustomerEntity customerEntity = entityManager.getReference(CustomerEntity.class, id);
        return CustomerMapper.mapCustomerEntityToCustomer(customerEntity);
    }
}
