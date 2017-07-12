package com.azarov.projects.core.customer.service.convert;

import com.azarov.projects.core.authorization.service.convert.AuthorizationConvert;
import com.azarov.projects.core.business.customer.datalayer.entity.BusinessCustomerEntity;
import com.azarov.projects.core.business.customer.service.BusinessCustomer;
import com.azarov.projects.core.business.customer.service.convert.BusinessCustomerConvert;
import com.azarov.projects.core.customer.datalayer.entity.CustomerEntity;
import com.azarov.projects.core.customer.service.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by AzarovD on 25.08.2016.
 */

@Service("customerConvert")
public class CustomerConvert {
    @Autowired
    @Qualifier("businessCustomerConvert")
    private BusinessCustomerConvert businessCustomerConvert;
    @Autowired
    @Qualifier("authorizationConvert")
    private AuthorizationConvert authorizationConvert;

    public CustomerEntity toCustomerEntity(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(customer.getId());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setMiddleName(customer.getMiddleName());
        entity.setBusinessCustomerEntity(getBusinessCustomerEntity(customer.getBusinessCustomer()));
        entity.setAuthorizationInfo(authorizationConvert.toAuthorizationEntity(customer.getAuthorizationInfo()));
        return entity;
    }

    private BusinessCustomerEntity getBusinessCustomerEntity(BusinessCustomer business) {
        return businessCustomerConvert.toBusinessCustomerEntity(business);
    }

    public Customer toCustomer(CustomerEntity entity) {
        Customer customer = new Customer();
        customer.setId(entity.getId());
        customer.setFirstName(entity.getFirstName());
        customer.setLastName(entity.getLastName());
        customer.setMiddleName(entity.getMiddleName());
        customer.setBusinessCustomer(getBusinessCustomer(entity.getBusinessCustomerEntity()));
        customer.setAuthorizationInfo(authorizationConvert.toAuthorization(entity.getAuthorizationInfo()));
        return customer;
    }

    private BusinessCustomer getBusinessCustomer(BusinessCustomerEntity entity) {
        return businessCustomerConvert.toBusinessCustomer(entity);
    }
}
