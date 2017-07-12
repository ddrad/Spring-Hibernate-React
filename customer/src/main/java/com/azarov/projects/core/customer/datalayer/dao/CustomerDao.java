package com.azarov.projects.core.customer.datalayer.dao;

import com.azarov.projects.core.customer.datalayer.entity.CustomerEntity;

import java.util.List;

/**
 * Created by AzarovD on 25.08.2016.
 */

public interface CustomerDao {

    CustomerEntity saveCustomer(CustomerEntity entity);

    CustomerEntity findById(int id);

    List<CustomerEntity> findAllCustomer();

    void updateCustomer(CustomerEntity entity);

}
