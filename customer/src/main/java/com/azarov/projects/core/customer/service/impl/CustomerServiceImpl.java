package com.azarov.projects.core.customer.service.impl;

import com.azarov.projects.core.customer.datalayer.dao.CustomerDao;
import com.azarov.projects.core.customer.datalayer.entity.CustomerEntity;
import com.azarov.projects.core.customer.service.Customer;
import com.azarov.projects.core.customer.service.CustomerService;
import com.azarov.projects.core.customer.service.convert.CustomerConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzarovD on 25.08.2016.
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    @Qualifier("customerDao")
    private CustomerDao dao;
    @Autowired
    @Qualifier("customerConvert")
    private CustomerConvert convert;

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {

        CustomerEntity entity = dao.saveCustomer(convert.toCustomerEntity(customer));

        return convert.toCustomer(entity);
    }

    @Override
    @Transactional
    public Customer findById(String id) {
        int intId = Integer.parseInt(id);
        CustomerEntity customerEntity = dao.findById(intId);
        if (customerEntity == null) {
            return null;
        }
        return convert.toCustomer(customerEntity);
    }

    @Override
    @Transactional
    public List<Customer> findAllEmployees() {
        List<CustomerEntity> entities = dao.findAllCustomer();
        List<Customer> customers = new ArrayList<Customer>();

        for (CustomerEntity entity : entities) {
            customers.add(convert.toCustomer(entity));
        }

        return customers;
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        dao.updateCustomer(convert.toCustomerEntity(customer));
    }

}
